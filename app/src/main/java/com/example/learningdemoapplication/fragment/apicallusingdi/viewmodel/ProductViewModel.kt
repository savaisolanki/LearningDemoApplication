package com.example.learningdemoapplication.fragment.apicallusingdi.viewmodel

import android.content.ContentValues.TAG
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

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



    private val _updatedData =
        MutableStateFlow<ResponseHandler<PostResponse.PostResponseItem>>(ResponseHandler.Loading)
    val updatedData: StateFlow<ResponseHandler<PostResponse.PostResponseItem>> get() = _dataPost

    fun getUpdatedAllPosts() {
        viewModelScope.launch {
            _updatedData.value = ResponseHandler.Loading
            productRepository.getAllPosts().catch { e ->
                Log.i(TAG, "fetchData: ${e.cause}")
                _updatedData.value = ResponseHandler.OnFailed(e.cause)
            }.collect {
                _updatedData.value = ResponseHandler.OnSuccessResponse(it)
            }

        }
    }


}