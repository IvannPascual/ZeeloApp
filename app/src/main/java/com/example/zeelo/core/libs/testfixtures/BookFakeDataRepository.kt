package com.example.zeelo.core.libs.testfixtures

import com.common.domain.BooksRepository
import com.common.domain.booklist.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BookFakeDataRepository(private val books: List<Book>): BooksRepository {
    override fun getBooks(offset: Int?, count: Int?): Flow<List<Book>> {
        return flowOf(books)
    }

    override suspend fun addNewBook(book: Book): Boolean {
        return false
    }

    companion object {
        val twoBooks = listOf(
            Book(1, "title", "link", "author", 10.0),
            Book(2, "title2", "lin2", "author2", 20.0)
        )
        val emptyBooks = listOf<Book>()
    }
}