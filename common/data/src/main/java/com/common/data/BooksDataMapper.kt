package com.common.data

import com.common.data.model.BookDataModel
import com.common.data.model.BookDetailDataModel
import com.common.domain.booklist.model.Book
import com.common.domain.booklist.model.defaultImageBook
import com.example.database.BookEntity
import javax.inject.Inject

class BooksDataMapper @Inject constructor() {

    fun map(bookDataModel: BookDataModel): Book =
        with(bookDataModel) {
            Book(
                id = id,
                link = link,
                title = title,
                author = detail.author,
                price = detail.price
            )
        }

    fun map(bookEntity: BookEntity): BookDataModel =
        with(bookEntity) {
            BookDataModel(
                id = id,
                title = title,
                link = link,
                detail = BookDetailDataModel(
                    id = id,
                    image = null,
                    title = title,
                    author = author,
                    price = price
                )
            )
        }

    fun map(book: Book): BookEntity =
        with(book) {
            BookEntity(
                id = id,
                title = title,
                link = link.ifEmpty { defaultImageBook },
                author = author,
                price = price
            )
        }

}