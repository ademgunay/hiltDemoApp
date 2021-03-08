package com.example.hiltdemo.di

import com.example.hiltdemo.repository.RemoteRepository
import com.example.hiltdemo.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class AlbumModule {
    @Binds
    abstract fun bindAlbumRepository(albumRepositoryImpl: RemoteRepositoryImpl): RemoteRepository
}