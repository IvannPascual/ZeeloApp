package com.common.domain

import com.common.domain.booklist.model.Book
import kotlinx.coroutines.flow.Flow


interface BooksRepository {
    fun getBooks(offset: Int? = 0, count: Int?= 10): Flow<List<Book>>

    suspend fun addNewBook(book: Book): Boolean
}