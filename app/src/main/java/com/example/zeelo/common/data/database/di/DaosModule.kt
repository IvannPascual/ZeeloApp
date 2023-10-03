package com.example.zeelo.common.data.database.di

import com.example.zeelo.common.data.database.BookDao
import com.example.zeelo.common.data.database.BooksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DaosModule {

    @Provides
    fun providesBooksDao(
        database: BooksDatabase,
    ): BookDao = database.bookDao()

}