package com.example.learningdemoapplication.di.framwork.qualifier

import android.content.ContentValues.TAG
import android.util.Log
import com.example.learningdemoapplication.activity.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

class QualifierClass @Inject constructor(
    @FName private val fName: String, @LName private val lName: String
) {
    fun getData() {
        Log.i(TAG, "getData: $fName $lName")
    }
}

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @FName
    @Provides
    fun getFName(): String = MainActivity.FName

    @LName
    @Provides
    fun getLName(): String = MainActivity.Lname

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName