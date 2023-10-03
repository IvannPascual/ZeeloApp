package com.common.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BookDetailDataModel(
    val id: Long,
    val image: String?=null,
    val title: String,
    val author: String,
    val price: Double
)