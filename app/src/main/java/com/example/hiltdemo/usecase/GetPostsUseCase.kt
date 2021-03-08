package com.example.hiltdemo.usecase

import com.example.hiltdemo.data.PostEntity
import com.example.hiltdemo.repository.RemoteRepository
import javax.inject.Inject

//TODO Implement use case and add module for Hilt in `di/UseCaseModule' to get posts for domain layer
interface GetPostsUseCase {
    suspend fun invoke(): List<PostEntity>
}

class GetPostsUseCaseImpl @Inject constructor(private val remoteRepository: RemoteRepository) : GetPostsUseCase {
    override suspend fun invoke(): List<PostEntity> {
        val result = remoteRepository.getPosts()
        return if (result.isSuccessful) {
            result.body() ?: emptyList()
        } else {
            throw Throwable(message = "Error when fetching posts")
        }
    }
}