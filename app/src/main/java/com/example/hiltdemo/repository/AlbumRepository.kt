package com.example.hiltdemo.repository

import android.util.Log
import com.example.hiltdemo.api.AlbumApi
import com.example.hiltdemo.data.Album
import retrofit2.Response
import javax.inject.Inject

interface AlbumRepository {
    suspend fun getAlbums(): Response<List<Album>>
}

class AlbumRepositoryImpl @Inject constructor(private val albumApi: AlbumApi) : AlbumRepository {
    override suspend fun getAlbums(): Response<List<Album>> {
        val result = albumApi.getAlbums()
        Log.d("RESPONSE", "$result")
        return result
    }
}