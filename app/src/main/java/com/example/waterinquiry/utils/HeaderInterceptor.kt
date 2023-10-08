package com.example.waterinquiry.utils

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain
            .request()
            .newBuilder()
            .apply {
                addHeader("Accept", "application/json")
            }.build()
    )
}