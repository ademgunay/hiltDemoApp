package com.example.hiltdemo.usecase

import com.example.hiltdemo.data.Album
import com.example.hiltdemo.repository.AlbumRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
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

@Module
@InstallIn(ActivityComponent::class)
abstract class GetAlbumsModule {
    @Binds
    abstract fun bindGetAlbumsUseCase(getAlbumsUseCaseImpl: GetAlbumsUseCaseImpl): GetAlbumsUseCase
}