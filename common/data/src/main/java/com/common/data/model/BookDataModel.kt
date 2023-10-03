package com.common.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BookDataModel(
    val id: Long,
    val link: String,
    val title: String,
    val detail: BookDetailDataModel
)
