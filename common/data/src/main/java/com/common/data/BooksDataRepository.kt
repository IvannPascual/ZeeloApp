package com.common.data

import com.common.data.datasource.BooksCacheDataSource
import com.common.data.datasource.BooksRemoteDataSource
import com.common.data.datasource.BooksRoomDataSource
import com.common.data.featureflags.FeatureFlagsRepository
import com.common.domain.BooksRepository
import com.common.domain.booklist.model.Book

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BooksDataRepository @Inject constructor(
    private val booksDataRepository: BooksRemoteDataSource,
    private val cacheDataSource: BooksCacheDataSource,
    private val roomDataSource: BooksRoomDataSource,
    private val mapper: BooksDataMapper,
    private val featureFlagsRepository: FeatureFlagsRepository,
) :
    BooksRepository {
    override fun getBooks(offset: Int?, count: Int?): Flow<List<Book>> {
        var cacheBooks = flowOf(listOf<Book>())
        var remoteBooks = flowOf(listOf<Book>())
        if (featureFlagsRepository.simulateGetBooksApiIsNotAvailable) {
            cacheBooks = cacheDataSource.getBooks(offset, count)
                .map { books ->
                    books.map {
                        mapper.map(it)
                    }
                }
        } else {
            remoteBooks = booksDataRepository.getBooks(0, 0)
                .map {
                    it.map { remoteData -> mapper.map(remoteData) }
                }
        }

        val databaseBooks = roomDataSource.getBooks(offset, count)
            .map { books ->
                books.map {
                    mapper.map(it)
                }
            }

        return combine(remoteBooks, databaseBooks, cacheBooks) { remote, database, cache ->
            remote + database + cache
        }
    }

    override suspend fun addNewBook(book: Book): Boolean = roomDataSource.addNewBook(book)

}