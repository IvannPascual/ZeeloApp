package com.example.zeelo.common.data.datasource

import android.util.Log
import com.example.zeelo.common.IoDispatcher
import com.example.zeelo.common.data.BooksDataMapper
import com.example.zeelo.common.data.database.BookDao
import com.example.zeelo.common.data.model.BookDataModel
import com.example.zeelo.features.booklist.domain.model.Book
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
        Log.d("###", result.toString())
        Log.d("###", "-----" + book.id.toString())
        return result.toString() == book.id.toString()

    }
}