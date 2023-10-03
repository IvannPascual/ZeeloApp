package com.common.data.datasource

import com.common.data.model.BookDataModel
import com.common.domain.booklist.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class BooksRemoteDataSource @Inject constructor() : BooksDataSource {
    override fun getBooks(offset: Int?, count: Int?): Flow<List<BookDataModel>> = flowOf(listOf())

    override suspend fun addNewBook(book: Book): Boolean = false
}