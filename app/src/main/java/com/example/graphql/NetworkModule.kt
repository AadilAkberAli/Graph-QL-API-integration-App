package com.example.graphql

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideApollo() : ApolloClient {
        return ApolloClient.builder()
            .serverUrl("http://10.10.12.13:8096/graphql/").build()
    }
}