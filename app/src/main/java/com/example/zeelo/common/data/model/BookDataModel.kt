package com.example.zeelo.common.data.model

data class BookDataModel(
    val id: Long,
    val link: String,
    val title: String,
    val detail: BookDetailDataModel
)
