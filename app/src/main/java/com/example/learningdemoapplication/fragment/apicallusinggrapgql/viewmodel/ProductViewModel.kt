package com.example.learningdemoapplication.fragment.apicallusinggrapgql.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.api.ApolloResponse
import com.example.learningdemoapplication.LaunchesQuery
import com.example.learningdemoapplication.fragment.apicallusinggrapgql.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private val _response: MutableLiveData<ApolloResponse<LaunchesQuery.Data>> = MutableLiveData()

    val response: LiveData<ApolloResponse<LaunchesQuery.Data>>
        get() = _response

    fun getLaunchesData() {

        viewModelScope.launch(Dispatchers.IO) {
            val responseData = productRepository.getLaunchesData()
            _response.postValue(responseData)

        }


    }
}