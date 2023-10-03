package com.example.zeelo.core.libs.testfixtures

import com.common.domain.BooksRepository
import com.common.domain.booklist.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BookFakeDataRepository(private val books: List<com.common.domain.booklist.model.Book>): com.common.domain.BooksRepository {
    override fun getBooks(offset: Int?, count: Int?): Flow<List<com.common.domain.booklist.model.Book>> {
        return flowOf(books)
    }

    override suspend fun addNewBook(book: com.common.domain.booklist.model.Book): Boolean {
        return false
    }

    companion object {
        val twoBooks = listOf(
            com.common.domain.booklist.model.Book(1, "title", "link", "author", 10.0),
            com.common.domain.booklist.model.Book(2, "title2", "lin2", "author2", 20.0)
        )
        val emptyBooks = listOf<com.common.domain.booklist.model.Book>()
    }
}