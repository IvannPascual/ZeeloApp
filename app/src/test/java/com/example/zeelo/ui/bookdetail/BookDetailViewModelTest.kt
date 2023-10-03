package com.example.zeelo.ui.bookdetail

import app.cash.turbine.test
import com.common.domain.bookdetail.GetBookDetailUseCase
import com.example.zeelo.features.bookdetail.ui.mvi.BookDetailMvi
import com.example.zeelo.features.bookdetail.ui.mvi.BookDetailViewModel
import com.example.zeelo.ui.bookdetail.GetBookDetailUseCaseStubs.givenBookDetail
import com.example.zeelo.ui.bookdetail.GetBookDetailUseCaseStubs.givenBookDetailNotFound
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class BookDetailViewModelTest {

    @MockK
    lateinit var getBookDetailUseCase: GetBookDetailUseCase

    private lateinit var sut: BookDetailViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        initSut()
    }



    @Test
    fun `GIVEN one book detail THEN view state is the expected`() = runTest {
        getBookDetailUseCase.givenBookDetail()
        initSut()
        sut.getBookById(1)
        sut.viewState.test {
            val loadingItem = awaitItem()
            val successItem = awaitItem()

            assert(loadingItem is BookDetailMvi.ViewState.Loading)
            assert(successItem is BookDetailMvi.ViewState.Success)
            assert((successItem as BookDetailMvi.ViewState.Success).bookDetail.id == 1L)
            assert(successItem.bookDetail.title == "title book1")
        }
    }

    @Test
    fun `GIVEN empty book detail THEN view state is the expected`() = runTest {
        getBookDetailUseCase.givenBookDetailNotFound()
        initSut()
        sut.getBookById(1)
        sut.viewState.test {
            val loadingItem = awaitItem()
            val successItem = awaitItem()

            assert(loadingItem is BookDetailMvi.ViewState.Loading)
            assert(successItem is BookDetailMvi.ViewState.BookDetailNotFound)
            this.cancelAndConsumeRemainingEvents()
        }
    }
    private fun initSut() {
        sut = BookDetailViewModel(getBookDetailUseCase)
    }
}