package com.common.data.datasource

import com.common.data.BooksDataMapper
import com.common.data.dispatchers.IoDispatcher
import com.common.data.model.BookDataModel
import com.common.domain.booklist.model.Book
import com.example.database.BookDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BooksRoomDataSource @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val mapper: BooksDataMapper,
    private val bookDao: BookDao
) : BooksDataSource {

    override fun getBooks(offset: Int?, count: Int?): Flow<List<BookDataModel>> =
        bookDao.getBooks().map { it.map { bookEntity -> mapper.map(bookEntity) } }
            .flowOn(ioDispatcher)

    override suspend fun addNewBook(book: Book): Boolean {
        val result = bookDao.insertBook(mapper.map(book))
        return result.toString() == book.id.toString()

    }
}