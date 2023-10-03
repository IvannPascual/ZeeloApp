package com.example.zeelo.features.bookdetail.domain

data class BookDetail(
    val id: Long,
    val image: String,
    val title: String,
    val author: String,
    val price: Double
)