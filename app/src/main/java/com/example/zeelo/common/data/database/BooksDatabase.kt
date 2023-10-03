package com.example.zeelo.common.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        BookEntity::class
    ],
    version = 1
)

abstract class BooksDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}