package com.example.learningdemoapplication.network.graphql

import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
* Graphql Client Object
* */
@Module
@InstallIn(SingletonComponent::class)
object GraphQlApiClient {

    /*
    * AplloClient instance
    * */
    @Singleton
    @Provides
    fun aplloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
            .build()
    }


}