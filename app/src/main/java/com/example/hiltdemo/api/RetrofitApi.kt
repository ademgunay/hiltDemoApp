package com.example.hiltdemo.api

import com.example.hiltdemo.data.AlbumEntity
import com.example.hiltdemo.data.PostEntity
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApi {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<AlbumEntity>>

    @GET("/posts")
    suspend fun getPosts(): Response<List<PostEntity>>
}