package com.example.hiltdemo.api

import com.example.hiltdemo.data.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumApi {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<Album>>
}