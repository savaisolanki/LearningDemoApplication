package com.example.learningdemoapplication.fragment.apicallusinggrapgql.repository

import android.content.Context
import android.net.ConnectivityManager
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.learningdemoapplication.LaunchesQuery
import com.example.learningdemoapplication.room.dao.ApiCallDiInterfaceDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apolloClient: ApolloClient,
    @ApplicationContext private val context: Context) {
    suspend fun getLaunchesData(): ApolloResponse<LaunchesQuery.Data> {
        return apolloClient.query(LaunchesQuery()).execute()
    }
}