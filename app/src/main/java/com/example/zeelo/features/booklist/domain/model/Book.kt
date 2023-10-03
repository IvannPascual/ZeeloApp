package com.example.zeelo.features.booklist.domain.model

data class Book(
    val id: Long,
    val title: String,
    val link: String,
    val author: String,
    val price: Double
)