package com.example.zeelo.data

import com.common.data.BooksDataMapper
import com.common.data.model.BookDataModel
import com.common.data.model.BookDetailDataModel
import com.common.domain.booklist.model.Book
import com.example.database.BookEntity
import junit.framework.TestCase.assertEquals
import org.junit.Test

class BooksDataMapperTest {

    private val sut = BooksDataMapper()

    @Test
    fun `GIVEN book data model THEN is mapped correctly to domain`() {
        val dataModel = BookDataModel(
            id = 1,
            title = "title book1",
            link = "link1",
            detail = BookDetailDataModel(
                id = 1,
                title = "title book1",
                author = "author 1",
                price = 10.0
            )
        )
        val expectedResult = Book(
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
        val expectedResult = BookDataModel(
            id = 1,
            title = "title book1",
            link = "link1",
            detail = BookDetailDataModel(
                id = 1,
                title = "title book1",
                author = "author 1",
                price = 10.0
            )
        )
        val result = sut.map(
            BookEntity(
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
        val bookDomainModel = Book(
            id = 1,
            title = "title book1",
            link = "link1",
            author = "author 1",
            price = 10.0
        )
        val expectedEntity = BookEntity(
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