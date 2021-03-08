package com.example.hiltdemo.repository

import android.util.Log
import com.example.hiltdemo.api.RetrofitApi
import com.example.hiltdemo.data.AlbumEntity
import com.example.hiltdemo.data.PostEntity
import retrofit2.Response
import javax.inject.Inject

interface RemoteRepository {
    suspend fun getAlbums(): Response<List<AlbumEntity>>
    suspend fun getPosts(): Response<List<PostEntity>>
}

// Annotate with @Inject to get dependencies from Hilt generated code
class RemoteRepositoryImpl @Inject constructor(private val retrofitApi: RetrofitApi) : RemoteRepository {
    override suspend fun getAlbums(): Response<List<AlbumEntity>> {
        val result = retrofitApi.getAlbums()
        Log.d("RESPONSE", "$result")
        return result
    }

    override suspend fun getPosts(): Response<List<PostEntity>> {
        return retrofitApi.getPosts()
    }
}