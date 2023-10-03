package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        BookEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class BooksDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}