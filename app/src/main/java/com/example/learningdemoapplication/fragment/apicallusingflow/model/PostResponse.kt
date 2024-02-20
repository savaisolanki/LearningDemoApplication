package com.example.learningdemoapplication.fragment.apicallusingflow.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class PostResponse(
    @SerializedName("postResponseItem")
    val postList: List<PostResponseItem?>? = listOf<PostResponseItem>()

) {
    @Entity
    data class PostResponseItem(
        @SerializedName("body")
        var body: String? = null,
        @SerializedName("id")
        @PrimaryKey(autoGenerate = true) val id: Int=0,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("userId")
        var userId: Int? = null,

        val fromRoom: Boolean = false

    )
}