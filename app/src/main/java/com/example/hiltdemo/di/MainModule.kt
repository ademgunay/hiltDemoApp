package com.example.hiltdemo.di

import com.example.hiltdemo.api.AlbumApi
import com.example.hiltdemo.presentation.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @Provides
    fun provideBaseUrl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    fun provideOkHttpBuilder(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder().baseUrl(provideBaseUrl()).client(provideOkHttpBuilder()).build()

    @Provides
    fun provideAlbumApi(retrofit: Retrofit): AlbumApi = retrofit.create(AlbumApi::class.java)
}