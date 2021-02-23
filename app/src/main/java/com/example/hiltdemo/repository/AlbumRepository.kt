package com.example.hiltdemo.repository

import com.example.hiltdemo.api.AlbumApi
import com.example.hiltdemo.data.Album
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Response
import javax.inject.Inject

interface AlbumRepository {
    suspend fun getAlbums(): Response<List<Album>>
}

class AlbumRepositoryImpl @Inject constructor(private val albumApi: AlbumApi) : AlbumRepository {
    override suspend fun getAlbums(): Response<List<Album>> {
        return albumApi.getAlbums()
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class AlbumModule {
    @Binds
    abstract fun bindAlbumRepository(albumRepositoryImpl: AlbumRepositoryImpl): AlbumRepository
}