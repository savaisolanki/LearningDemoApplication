package com.example.learningdemoapplication.fragment.apicallusingdi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningdemoapplication.fragment.apicallusingdi.model.ProductResponse
import com.example.learningdemoapplication.fragment.apicallusingdi.repository.ProductRepository
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import com.example.learningdemoapplication.utils.ResponseHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    /*
    * get all products data
    * */
    private val _response: MutableLiveData<ProductResponse> = MutableLiveData()
    val response: LiveData<ProductResponse>
        get() = _response

    fun getProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            val responseData = productRepository.getProduct()
            if (responseData.isSuccessful) {
                _response.postValue(responseData.body())
            } else {
                Log.i(TAG, "getProduct: Error")
            }
        }
    }

    /*
    * get all post data
    * */
    private val _dataPost =
        MutableStateFlow<ResponseHandler<PostResponse.PostResponseItem>>(ResponseHandler.Loading)
    val dataPost: StateFlow<ResponseHandler<PostResponse.PostResponseItem>> get() = _dataPost
    fun getAllPosts() {
        viewModelScope.launch {
            _dataPost.value = ResponseHandler.Loading
            productRepository.getAllPosts().catch { e ->
                Log.i(TAG, "fetchData: ${e.cause}")
                _dataPost.value = ResponseHandler.OnFailed(e.cause)
            }.collect {
                _dataPost.value = ResponseHandler.OnSuccessResponse(it)
            }

        }
    }
    /*
    * for loading  observe and maintain visibility
    * */
    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    /*
    * Fetch data from room
    * */
    fun fetchDataAndStoreInDatabase() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                productRepository.fetchDataAndStoreInDatabase()
            } finally {
                _isLoading.value = false
            }
        }
    }


    /*
    * Delete posts Data
    * */
    fun deleteItemFromDatabase() {
        viewModelScope.launch {
            try {
                productRepository.deleteItem()
            } finally {
                _isLoading.value = false
            }
        }
    }

    val allData: Flow<List<PostResponse.PostResponseItem>> = productRepository.getAllData()

    /*
    * Delete By ID
    * */
    fun deleteItemById(itemId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                productRepository.deletePostById(itemId)
            } finally {
                _isLoading.value = false
            }
        }
    }

    /*
    * Add Post
    * */
    fun addPostToRoom(post: PostResponse.PostResponseItem) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                productRepository.insertPost(post)
            } catch (e: Exception) {
                Log.e(TAG, "Error adding post: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }


    /*
    * Update Post
    * */
    fun updatePostToRoom(post: PostResponse.PostResponseItem) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                productRepository.updatePost(post)
            } catch (e: Exception) {
                Log.e(TAG, "Error adding post: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    /*
    * Define Tag
    * */
    companion object {
        private const val TAG = "ProductViewModel"
    }


}


/*
@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private val TAG = "ProductViewModel"

    private val _dataPost = MutableStateFlow<ResponseHandler<PostResponse.PostResponseItem>>(ResponseHandler.Loading)
    val dataPost: StateFlow<ResponseHandler<PostResponse.PostResponseItem>> get() = _dataPost

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        fetchData()
    }

    private fun fetchData() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                productRepository.getAllPosts()
                    .catch { e ->
                        Log.e(TAG, "Error fetching data: ${e.message}", e)
                        _dataPost.value = ResponseHandler.OnFailed(e)
                    }
                    .collect { data ->
                        _dataPost.value = ResponseHandler.OnSuccessResponse(data)
                    }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching data: ${e.message}", e)
                _dataPost.value = ResponseHandler.OnFailed(e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteItemById(itemId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                productRepository.deletePostById(itemId)
            } catch (e: Exception) {
                Log.e(TAG, "Error deleting item: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addPostToRoom(post: PostResponse.PostResponseItem) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                productRepository.insertPost(post)
            } catch (e: Exception) {
                Log.e(TAG, "Error adding post: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updatePostToRoom(post: PostResponse.PostResponseItem) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                productRepository.updatePost(post)
            } catch (e: Exception) {
                Log.e(TAG, "Error updating post: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}
*/


