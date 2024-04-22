package com.example.graphql

import okhttp3.Interceptor
import okhttp3.Response

class MainInterceptor  : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "token put_your_personal_access_token_here")

        return chain.proceed(request.build())
    }
}