package com.example.hiltdemo.di

import com.example.hiltdemo.usecase.GetAlbumsUseCase
import com.example.hiltdemo.usecase.GetAlbumsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class GetAlbumsModule {
    @Binds
    abstract fun bindGetAlbumsUseCase(getAlbumsUseCaseImpl: GetAlbumsUseCaseImpl): GetAlbumsUseCase
}