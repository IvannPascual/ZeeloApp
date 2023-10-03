package com.common.domain.addnewbook

import com.common.domain.BooksRepository
import com.common.domain.booklist.model.Book
import javax.inject.Inject

class AddNewBookUseCase @Inject constructor(private val repository: BooksRepository) {
     suspend operator fun invoke(book: Book): Boolean = repository.addNewBook(book)
}