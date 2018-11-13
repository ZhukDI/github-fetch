package com.github.zhukdi.githubfetch.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object GitHubClient {
    private var ourInstance : Retrofit? = null

    val instance : Retrofit
        get() {
            if (ourInstance == null) {
                val httpClient = OkHttpClient.Builder()
                val interceptor = Interceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .url(chain.request()
                            .url()
                            .newBuilder()
                            .addQueryParameter("access_token", UrlManager.ACCESS_TOKEN)
                            .build())
                        .build()
                    chain.proceed(request)
                }
                httpClient.addInterceptor(interceptor)
                ourInstance = Retrofit.Builder()
                    .baseUrl(UrlManager.API_HOST)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return  ourInstance!!
        }
}