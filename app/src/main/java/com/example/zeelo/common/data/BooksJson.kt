package com.example.zeelo.common.data

import com.example.zeelo.common.data.model.BookDataModel
import com.example.zeelo.common.data.model.BookDetailDataModel

object BooksJson {

    val books = listOf(

        BookDataModel(
            id = 1,
            title = "title book1",
            link = "link1",
            detail = BookDetailDataModel(
                id = 1,
                title = "title book1",
                author = "author 1",
                price = 10.0
            )
        ),
        BookDataModel(
            id = 2,
            title = "title book2",
            link = "link2",
            detail = BookDetailDataModel(
                id = 2,
                title = "title book 2",
                author = "author 2",
                price = 20.0
            )
        ),
        BookDataModel(
            id = 3,
            title = "title book3",
            link = "link3",
            detail = BookDetailDataModel(
                id = 3,
                title = "title book 3",
                author = "author 3",
                price = 30.0
            )
        ),
        BookDataModel(
            id = 4,
            title = "title book4",
            link = "link4",
            detail = BookDetailDataModel(
                id = 4,
                title = "title book 4",
                author = "author 4",
                price = 40.0
            )
        ),
    )
}