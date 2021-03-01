package com.example.hiltdemo.usecase

import com.example.hiltdemo.data.Album
import com.example.hiltdemo.repository.AlbumRepository
import javax.inject.Inject

interface GetAlbumsUseCase {
    suspend fun invoke(): List<Album>
}

class GetAlbumsUseCaseImpl @Inject constructor(private val albumRepository: AlbumRepository) : GetAlbumsUseCase {

    override suspend fun invoke(): List<Album> {
        val result = albumRepository.getAlbums()
        if (result.isSuccessful) {
            return result.body() ?: emptyList()
        } else {
            throw Throwable(message = result.message())
        }
    }
}