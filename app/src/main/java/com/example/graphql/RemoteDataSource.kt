package com.example.graphql

import GetUserListQuery
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.ApolloQueryCall


class RemoteDataSource {
    private var client: ApolloClient = NetworkModule.provideApollo()

    fun getUserList(): ApolloQueryCall<GetUserListQuery.Data>? {
        return client.query(GetUserListQuery())
    }
}