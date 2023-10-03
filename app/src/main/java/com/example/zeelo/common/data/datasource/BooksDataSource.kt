package com.example.zeelo.common.data.datasource

import com.example.zeelo.common.data.model.BookDataModel
import com.example.zeelo.features.booklist.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDataSource {

    fun getBooks(offset: Int?, count: Int?): Flow<List<BookDataModel>>
    suspend fun addNewBook(book: Book): Boolean
}