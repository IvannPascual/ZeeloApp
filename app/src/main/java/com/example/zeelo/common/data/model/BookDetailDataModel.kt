package com.example.zeelo.common.data.model

data class BookDetailDataModel(
    val id: Long,
    val image: String?=null,
    val title: String,
    val author: String,
    val price: Double
)