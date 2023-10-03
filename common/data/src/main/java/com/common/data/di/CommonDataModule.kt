package com.common.data.di

import com.common.data.BooksDataMapper
import com.common.data.BooksDataRepository
import com.common.data.datasource.BooksCacheDataSource
import com.common.data.datasource.BooksRemoteDataSource
import com.common.data.datasource.BooksRoomDataSource
import com.common.data.featureflags.FeatureFlagsRepository
import com.common.domain.BooksRepository
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
