package com.example.learningdemoapplication.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import kotlinx.coroutines.flow.Flow

/*
* Dao interface
* */
@Dao
interface ApiCallDiInterfaceDao {

    /*
    * insert all data in room
    * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<PostResponse.PostResponseItem>)

    /*
    * get all data from room
    * */
    @Query("SELECT * FROM postresponseitem")
    fun getAllProducts(): Flow<List<PostResponse.PostResponseItem>>

    @Delete
    suspend fun deletePost(post: PostResponse.PostResponseItem)

    @Update
    suspend fun updatePost(post: PostResponse.PostResponseItem)
}
