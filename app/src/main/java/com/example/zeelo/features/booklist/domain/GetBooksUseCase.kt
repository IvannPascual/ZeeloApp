package com.example.zeelo.features.booklist.domain

import com.example.zeelo.common.domain.BooksRepository
import com.example.zeelo.features.booklist.domain.model.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(private val repository: BooksRepository) {
    operator fun invoke(): Flow<List<Book>> = repository.getBooks(0,5)
}