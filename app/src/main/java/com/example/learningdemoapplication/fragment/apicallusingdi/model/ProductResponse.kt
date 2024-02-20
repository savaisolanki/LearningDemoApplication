package com.example.learningdemoapplication.fragment.apicallusingdi.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("limit")
    var limit: Int? = null,
    @SerializedName("products")
    var products: List<Product?>? = listOf(),
    @SerializedName("skip")
    var skip: Int? = null,
    @SerializedName("total")
    var total: Int? = null
) {
    data class Product(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("brand")
        var brand: String? = null,
        @SerializedName("category")
        var category: String? = null,
        @SerializedName("description")
        var description: String? = null,
        @SerializedName("discountPercentage")
        var discountPercentage: Double? = null,
        @SerializedName("images")
        var images: List<String?>? = listOf(),
        @SerializedName("price")
        var price: Int? = null,
        @SerializedName("rating")
        var rating: Double? = null,
        @SerializedName("stock")
        var stock: Int? = null,
        @SerializedName("thumbnail")
        var thumbnail: String? = null,
        @SerializedName("title")
        var title: String? = null
    )
}