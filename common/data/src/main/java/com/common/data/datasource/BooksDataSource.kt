package com.common.data.datasource

import com.common.data.model.BookDataModel
import com.common.domain.booklist.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDataSource {

    fun getBooks(offset: Int?, count: Int?): Flow<List<BookDataModel>>
    suspend fun addNewBook(book: Book): Boolean
}