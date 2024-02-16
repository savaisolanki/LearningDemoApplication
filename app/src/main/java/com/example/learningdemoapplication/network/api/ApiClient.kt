package com.example.learningdemoapplication.network.api

import android.content.Context
import androidx.room.Room
import com.example.learningdemoapplication.room.dao.ApiCallDiInterfaceDao
import com.example.learningdemoapplication.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/*
* Retrofit Client Object
* */
@Module
@InstallIn(SingletonComponent::class)
object ApiClient {

    /*
    * Retrofit instance for JSONPlaceholder API
    * */
    @Provides
    @Singleton
    @Named("jsonPlaceholder")
    fun provideJsonPlaceholderRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /*
    * Retrofit instance for DummyJSON API
    * */
    @Provides
    @Singleton
    @Named("dummyJson")
    fun provideDummyJsonRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /*
    * AppInterfaceJsonPlaceHolder using JSONPlaceholder Retrofit
    * */
    @Provides
    @Singleton
    fun provideJsonPlaceholderApiInterface(@Named("jsonPlaceholder") retrofit: Retrofit): AppInterfaceJsonPlacePost =
        retrofit.create(AppInterfaceJsonPlacePost::class.java)

    /*
    *  AppInterfaceDummyJson using DummyJSON Retrofit
    * */
    @Provides
    @Singleton
    fun provideDummyJsonApiInterface(@Named("dummyJson") retrofit: Retrofit): AppInterfaceDummyJsonProduct =
        retrofit.create(AppInterfaceDummyJsonProduct::class.java)

    /*
    * DAO for Room database
    * */
    @Singleton
    @Provides
    fun getDao(appDatabase: AppDatabase): ApiCallDiInterfaceDao {
        return appDatabase.getDao()
    }

    /*
    * Room database instance
    * */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "PostItemsResponse"
        ).build()
    }
}