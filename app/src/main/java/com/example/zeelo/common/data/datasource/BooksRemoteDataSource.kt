package com.example.zeelo.common.data.datasource

import com.example.zeelo.common.IoDispatcher
import com.example.zeelo.common.data.model.BookDataModel
import com.example.zeelo.features.booklist.domain.model.Book
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class BooksRemoteDataSource @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : BooksDataSource {
    override fun getBooks(offset: Int?, count: Int?): Flow<List<BookDataModel>> = flowOf(listOf())

    override suspend fun addNewBook(book: Book): Boolean = false

}