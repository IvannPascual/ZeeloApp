package com.common.domain.booklist.model

data class Book(
    val id: Long,
    val title: String,
    val link: String,
    val author: String,
    val price: Double
)

const val defaultImageBook = "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson2.jpg"