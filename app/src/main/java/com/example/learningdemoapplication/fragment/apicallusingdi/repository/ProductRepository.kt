package com.example.learningdemoapplication.fragment.apicallusingdi.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.learningdemoapplication.fragment.apicallusingdi.model.ProductResponse
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import com.example.learningdemoapplication.network.api.AppInterfaceDummyJsonProduct
import com.example.learningdemoapplication.network.api.AppInterfaceJsonPlacePost
import com.example.learningdemoapplication.room.dao.ApiCallDiInterfaceDao
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val appInterfaceJsonPlacePost: AppInterfaceJsonPlacePost,
    private val appInterfaceDummyJsonProduct: AppInterfaceDummyJsonProduct,
    private val dao: ApiCallDiInterfaceDao,
    @ApplicationContext private val context: Context
) {
    suspend fun getProduct(): Response<ProductResponse> {
        return appInterfaceDummyJsonProduct.getProducts()
    }

    /*
     * this function check if internet is available data insert into room  and
     * And from room use for if internet is not available from room true if this true  in adapter side
     * we set textview  visibility
     * */
    suspend fun getAllPosts(): Flow<List<PostResponse.PostResponseItem>> {
        return if (isInternetAvailable(context)) {
            val response = appInterfaceJsonPlacePost.getPostUsingFlow()

            if (response.isNotEmpty()) {
                dao.insertAll(response.map { it.copy(fromRoom = false) })
            }
            dao.getAllProducts()

        } else {
            dao.getAllProducts().map { list ->
                list.map { it.copy(fromRoom = true) }
            }
        }.flowOn(Dispatchers.IO)
    }

    /*
    * Internet Available or Not
    * */
    private fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }



}

