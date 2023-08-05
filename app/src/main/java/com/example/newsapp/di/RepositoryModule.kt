package com.example.newsapp.di

import com.example.newsapp.data.network.NewsInterface
import com.example.newsapp.data.repository.INewsRepository
import com.example.newsapp.data.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepo(newsApi: NewsInterface): INewsRepository = NewsRepository(newsApi)
}