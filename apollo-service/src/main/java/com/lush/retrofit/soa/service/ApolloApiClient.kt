package com.lush.retrofit.soa.service

import com.apollographql.apollo.ApolloClient
import com.lush.retrofit.soa.service.base.BaseUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApolloApiClient {

    fun getClient(
        baseUrl: String = BaseUrl.getBaseUrl(),
        headers: Map<String, String> = mapOf()

    ): ApolloClient? {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build()

        httpClient.addInterceptor(logging)
        if (headers.isNotEmpty()) {
            httpClient.addInterceptor(getHeadersInterceptor(headers))
        }

        return ApolloClient.builder()
            .serverUrl(baseUrl)
            .okHttpClient(httpClient.build())
            .build()
    }

    private fun getHeadersInterceptor(headers: Map<String, String>): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
            headers.forEach { header ->
                request.removeHeader(header.key)
                request.addHeader(header.key, header.value)
            }
            request.method(original.method(), original.body())
            chain.proceed(request.build())
        }
    }
}