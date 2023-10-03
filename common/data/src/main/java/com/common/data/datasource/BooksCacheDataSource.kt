package com.common.data.datasource

import com.common.data.BooksJson
import com.common.data.dispatchers.IoDispatcher
import com.common.data.model.BookDataModel
import com.common.domain.booklist.model.Book
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class BooksCacheDataSource @Inject constructor(@IoDispatcher private val ioDispatcher: CoroutineDispatcher) :
    BooksDataSource {

    override fun getBooks(offset: Int?, count: Int?): Flow<List<BookDataModel>> {
        val books = Json.decodeFromString<List<BookDataModel>>(BooksJson.books)
        return flowOf(books).flowOn(ioDispatcher)
    }


    override suspend fun addNewBook(book: Book): Boolean = false


}