package com.common.domain.booklist

import com.common.domain.booklist.model.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(private val repository: com.common.domain.BooksRepository) {
    operator fun invoke(): Flow<List<Book>> = repository.getBooks(0,5)
}