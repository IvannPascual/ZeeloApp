package com.example.zeelo.common.data

import com.example.zeelo.common.data.database.BookEntity
import com.example.zeelo.common.data.model.BookDataModel
import com.example.zeelo.common.data.model.BookDetailDataModel
import com.example.zeelo.features.booklist.domain.model.Book
import com.example.zeelo.features.booklist.domain.model.defaultImageBook
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