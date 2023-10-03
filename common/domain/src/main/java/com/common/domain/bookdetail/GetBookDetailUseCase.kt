package com.common.domain.bookdetail

import com.common.domain.BooksRepository
import com.common.domain.booklist.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetBookDetailUseCase @Inject constructor(private val repository: BooksRepository) {
    operator fun invoke(bookId: Long): Flow<Book?> =
        repository.getBooks(0, 5).map { books ->
            books.find { book ->
                bookId == book.id
            }
        }
}