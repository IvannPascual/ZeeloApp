package com.example.zeelo.common.domain

import com.example.zeelo.features.booklist.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    fun getBooks(offset: Int? = 0, count: Int?= 10): Flow<List<Book>>

    suspend fun addNewBook(book: Book): Boolean
}