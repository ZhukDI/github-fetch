package com.github.zhukdi.githubfetch.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object GitHubClient {
    private var ourInstance : Retrofit? = null

    val instance : Retrofit
        get() {
            if (ourInstance == null) {
                ourInstance = Retrofit.Builder()
                    .baseUrl(" https://api.github.com/repos/ZhukDI/javaee-library")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return  ourInstance!!
        }

}