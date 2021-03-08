package com.example.hiltdemo.usecase

import com.example.hiltdemo.data.AlbumEntity
import com.example.hiltdemo.repository.RemoteRepository
import javax.inject.Inject

interface GetAlbumsUseCase {
    suspend fun invoke(): List<AlbumEntity>
}

// Annotate with @Inject to get dependencies from Hilt generated code
class GetAlbumsUseCaseImpl @Inject constructor(private val remoteRepository: RemoteRepository) : GetAlbumsUseCase {

    override suspend fun invoke(): List<AlbumEntity> {
        val result = remoteRepository.getAlbums()
        if (result.isSuccessful) {
            return result.body() ?: emptyList()
        } else {
            throw Throwable(message = result.message())
        }
    }
}