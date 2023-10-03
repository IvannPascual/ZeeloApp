package com.example.zeelo.features.addnewbook.domain

import com.example.zeelo.common.domain.BooksRepository
import com.example.zeelo.features.booklist.domain.model.Book
import javax.inject.Inject

class AddNewBookUseCase @Inject constructor(private val repository: BooksRepository) {
     suspend operator fun invoke(book: Book): Boolean = repository.addNewBook(book)
}