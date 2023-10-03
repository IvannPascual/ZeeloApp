package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val link: String,
    val price: Double,
    val author: String
)
