package com.example.learningdemoapplication.network.api

import com.example.learningdemoapplication.fragment.apicallusingdi.model.ProductResponse
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import retrofit2.Response
import retrofit2.http.GET

/*
* Api Interface for both different different URL
* */
interface AppInterfaceJsonPlacePost {
    @GET("posts")
    suspend fun getPostUsingFlow(): List<PostResponse.PostResponseItem>
}

interface AppInterfaceDummyJsonProduct {
    @GET("products")
    suspend fun getProducts(): Response<ProductResponse>
}