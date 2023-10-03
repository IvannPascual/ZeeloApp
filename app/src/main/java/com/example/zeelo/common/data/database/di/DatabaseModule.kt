package com.example.zeelo.common.data.database.di

import android.content.Context
import androidx.room.Room
import com.example.zeelo.common.data.database.BooksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesBookDatabase(
        @ApplicationContext context: Context,
    ): BooksDatabase = Room.databaseBuilder(
        context,
        BooksDatabase::class.java,
        "book-database",
    ).build()
}
