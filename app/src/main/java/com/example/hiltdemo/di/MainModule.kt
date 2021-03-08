package com.example.hiltdemo.di

import com.example.hiltdemo.api.RetrofitApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityRetainedComponent::class)
object MainModule {

    @Provides
    fun provideBaseUrl() = "https://jsonplaceholder.typicode.com"

    @Provides
    fun provideOkHttpBuilder(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun provideRetrofitInstance(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(provideBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpBuilder()).build()

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RetrofitApi = retrofit.create(RetrofitApi::class.java)
}