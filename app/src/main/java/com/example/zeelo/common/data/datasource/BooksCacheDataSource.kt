package com.example.zeelo.common.data.datasource

import com.example.zeelo.common.dispatchers.IoDispatcher
import com.example.zeelo.common.data.BooksJson
import com.example.zeelo.common.data.model.BookDataModel
import com.example.zeelo.features.booklist.domain.model.Book
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