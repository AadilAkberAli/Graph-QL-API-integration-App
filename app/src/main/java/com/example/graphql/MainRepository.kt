package com.example.graphql

import GetUserListQuery
import com.apollographql.apollo.ApolloQueryCall
import javax.inject.Inject


class MainRepository @Inject constructor(private  val remoteDataSource: RemoteDataSource) {

    fun getUserList(): ApolloQueryCall<GetUserListQuery.Data>? {
        return remoteDataSource.getUserList()
    }


}
