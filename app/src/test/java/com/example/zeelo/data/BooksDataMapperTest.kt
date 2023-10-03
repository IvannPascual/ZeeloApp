package com.example.zeelo.data

import com.common.data.BooksDataMapper
import com.example.database.BookEntity
import com.common.domain.booklist.model.Book
import junit.framework.TestCase.assertEquals
import org.junit.Test

class BooksDataMapperTest {

    private val sut = BooksDataMapper()

    @Test
    fun `GIVEN book data model THEN is mapped correctly to domain`() {
        val dataModel = com.common.data.model.BookDataModel(
            id = 1,
            title = "title book1",
            link = "link1",
            detail = com.common.data.model.BookDetailDataModel(
                id = 1,
                title = "title book1",
                author = "author 1",
                price = 10.0
            )
        )
        val expectedResult = com.common.domain.booklist.model.Book(
            id = 1,
            title = "title book1",
            link = "link1",
            author = "author 1",
            price = 10.0
        )

        val result = sut.map(dataModel)
        assertEquals(expectedResult, result)
    }


    @Test
    fun `GIVEN book entity database model THEN is mapped correctly to book data model`() {
        val expectedResult = com.common.data.model.BookDataModel(
            id = 1,
            title = "title book1",
            link = "link1",
            detail = com.common.data.model.BookDetailDataModel(
                id = 1,
                title = "title book1",
                author = "author 1",
                price = 10.0
            )
        )
        val result = sut.map(
            com.example.database.BookEntity(
                id = 1,
                link = "link1",
                title = "title book1",
                author = "author 1",
                price = 10.0
            )
        )
        assertEquals(expectedResult, result)
    }

    @Test
    fun `GIVEN book domain model THEN is mapped correctly to book database model`() {
        val bookDomainModel = com.common.domain.booklist.model.Book(
            id = 1,
            title = "title book1",
            link = "link1",
            author = "author 1",
            price = 10.0
        )
        val expectedEntity = com.example.database.BookEntity(
            id = 1,
            link = "link1",
            title = "title book1",
            author = "author 1",
            price = 10.0
        )
        val result = sut.map(bookDomainModel)
        assertEquals(expectedEntity, result)
    }
}