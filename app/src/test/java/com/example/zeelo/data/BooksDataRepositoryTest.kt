package com.example.zeelo.data

import com.common.data.BooksDataMapper
import com.common.data.BooksDataRepository
import com.common.data.datasource.BooksCacheDataSource
import com.common.data.datasource.BooksRoomDataSource
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import app.cash.turbine.test
import com.common.data.datasource.BooksRemoteDataSource
import com.common.data.featureflags.FeatureFlagsRepository
import com.common.data.model.BookDataModel
import com.common.data.model.BookDetailDataModel
import io.mockk.MockKAnnotations
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest


class BooksDataRepositoryTest {

    @MockK(relaxUnitFun = true)
    lateinit var remoteDataSource: BooksRemoteDataSource

    @MockK(relaxUnitFun = true)
    lateinit var cacheDataSource: BooksCacheDataSource

    @MockK(relaxUnitFun = true)
    lateinit var booksDataSource: BooksRoomDataSource

    private lateinit var featureFlagsRepository: FeatureFlagsRepository

    private lateinit var mapper: BooksDataMapper

    private lateinit var sut: BooksDataRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        mapper = BooksDataMapper()
        featureFlagsRepository = FeatureFlagsRepository()
        initSut()
    }

    @Test
    fun `GIVEN one book from database source and other from cache THEN the flow collect the expected result`() =
        runTest {
            val cacheBook = BookDataModel(
                id = 1,
                title = "cache title book1",
                link = "link1",
                detail = BookDetailDataModel(
                    id = 1,
                    title = "title book1",
                    author = "author 1",
                    price = 10.0
                )
            )
            val dataBaseBook = BookDataModel(
                id = 1,
                title = "database title book2",
                link = "link2",
                detail = BookDetailDataModel(
                    id = 2,
                    title = "title book2",
                    author = "author 2",
                    price = 20.0
                )
            )
            every { cacheDataSource.getBooks(any(), any()) }.returns(
                flowOf(
                    listOf(
                        cacheBook
                    )
                )
            )

            every { booksDataSource.getBooks(any(), any()) }.returns(
                flowOf(
                    listOf(
                        dataBaseBook
                    )
                )
            )

            sut.getBooks().test {
                val item = awaitItem()

                assertEquals(mapper.map(cacheBook), item[1])
                awaitComplete()
            }
        }

    private fun initSut() {
        sut = BooksDataRepository(
            remoteDataSource,
            cacheDataSource,
            booksDataSource,
            BooksDataMapper(),
            featureFlagsRepository
        )
    }
}