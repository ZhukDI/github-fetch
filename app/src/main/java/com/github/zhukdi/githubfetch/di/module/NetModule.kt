package com.github.zhukdi.githubfetch.di.module

import android.app.Application
import com.github.zhukdi.githubfetch.network.IGitHubAPI
import com.github.zhukdi.githubfetch.network.UrlManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    fun provideGitHubService(retrofit: Retrofit): IGitHubAPI {
        return retrofit.create(IGitHubAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(UrlManager.API_HOST).build()
    }

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideInterceptor() : Interceptor {
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
        return interceptor
    }

    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
//            .addInterceptor(ErrorInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

}