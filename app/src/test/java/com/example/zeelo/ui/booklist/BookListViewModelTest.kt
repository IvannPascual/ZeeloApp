package com.example.zeelo.ui.booklist

import app.cash.turbine.test
import com.common.domain.booklist.GetBooksUseCase
import com.common.domain.booklist.model.Book
import com.example.zeelo.features.booklist.ui.mvi.BookListMvi
import com.example.zeelo.features.booklist.ui.mvi.BookListViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class BookListViewModelTest {

    @MockK
    lateinit var getBooksUseCase: com.common.domain.booklist.GetBooksUseCase

    lateinit var sut: BookListViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        every { getBooksUseCase.invoke() }.returns(
            flowOf(
                listOf(
                    com.common.domain.booklist.model.Book(
                        id = 1,
                        title = "title book1",
                        link = "link1",
                        author = "author 1",
                        price = 10.0
                    )
                )
            )
        )
        initSut()
    }

    @Test
    fun `GIVEN list of books THEN view state is the expected`() = runTest {
        initSut()
        sut.viewState.test {
            val loadingItem = awaitItem()
            val successItem = awaitItem()

            assert(loadingItem is BookListMvi.ViewState.Loading)
            assert(successItem is BookListMvi.ViewState.Success)
            assert((successItem as BookListMvi.ViewState.Success).books.first().id == 1L)
        }
    }

    @Test
    fun `GIVEN empty list of books THEN view state is the expected`() = runTest {
        every { getBooksUseCase.invoke() }.returns(flowOf(listOf()))
        initSut()
        sut.viewState.test {
            val loadingItem = awaitItem()
            val noItems = awaitItem()
            assert(noItems is BookListMvi.ViewState.EmptyData)
        }
    }

    @Test
    fun `WHEN go to detail view action THEN view effect is the expected`() = runTest {
        initSut()
        sut.onHandleViewAction(BookListMvi.ViewAction.GoToBookDetail(1))
        sut.viewEffect.test {
            val goToDetailViewAction = awaitItem()
            assert(goToDetailViewAction is BookListMvi.ViewEffect.GoToBookDetail)
        }
    }

    private fun initSut() {
        sut = BookListViewModel(getBooksUseCase)
    }
}