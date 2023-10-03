package com.example.zeelo.ui.bookdetail

import com.common.domain.bookdetail.GetBookDetailUseCase
import io.mockk.every
import kotlinx.coroutines.flow.flowOf

object GetBookDetailUseCaseStubs {
    fun GetBookDetailUseCase.givenBookDetail() {
        every { invoke(bookId = any()) }.returns(
            flowOf(

                com.common.domain.booklist.model.Book(
                    id = 1,
                    title = "title book1",
                    link = "link1",
                    author = "author 1",
                    price = 10.0
                )
            )
        )

    }

    fun GetBookDetailUseCase.givenBookDetailNotFound() {
        every { invoke(bookId = any()) }.returns(
            flowOf(null)
        )
    }

}