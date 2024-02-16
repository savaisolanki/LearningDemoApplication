package com.example.learningdemoapplication.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import com.example.learningdemoapplication.room.dao.ApiCallDiInterfaceDao

/*
* Room Database Create
* */
@Database(entities = [PostResponse.PostResponseItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): ApiCallDiInterfaceDao
}
