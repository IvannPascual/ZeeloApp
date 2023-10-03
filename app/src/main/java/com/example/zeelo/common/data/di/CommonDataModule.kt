package com.example.zeelo.common.data.di

import com.example.zeelo.common.data.BooksDataMapper
import com.example.zeelo.common.data.BooksDataRepository
import com.example.zeelo.common.domain.BooksRepository
import com.example.zeelo.common.data.datasource.BooksCacheDataSource
import com.example.zeelo.common.data.datasource.BooksRemoteDataSource
import com.example.zeelo.common.data.datasource.BooksRoomDataSource
import com.example.zeelo.common.data.featureflags.FeatureFlagsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CommonDataModule {

    @Provides
    fun provideBookRepository(
        booksRemoteDataSource: BooksRemoteDataSource,
        booksCacheDataSource: BooksCacheDataSource,
        booksRoomDataSource: BooksRoomDataSource,
        mapper: BooksDataMapper,
        featureFlagsRepository: FeatureFlagsRepository
    ): BooksRepository = BooksDataRepository(
        booksRemoteDataSource,
        booksCacheDataSource,
        booksRoomDataSource,
        mapper,
        featureFlagsRepository
    )

    @Provides
    fun provideFeatureFlagRepository() = FeatureFlagsRepository()

}
