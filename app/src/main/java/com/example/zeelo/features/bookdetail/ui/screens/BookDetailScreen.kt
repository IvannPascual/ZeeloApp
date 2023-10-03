package com.example.zeelo.features.bookdetail.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.zeelo.R
import com.example.zeelo.core.libs.ui.views.atoms.CircularProgressIndicatorAtom
import com.example.zeelo.features.bookdetail.ui.views.BookDetailNotFoundView
import com.example.zeelo.features.bookdetail.ui.views.BookDetailView
import com.example.zeelo.features.bookdetail.ui.mvi.BookDetailMvi
import com.example.zeelo.features.bookdetail.ui.mvi.BookDetailViewModel
import com.example.zeelo.features.booklist.domain.model.Book

@Composable
fun BookDetailScreen(bookId: Long, viewModel: BookDetailViewModel = hiltViewModel()) {
    viewModel.getBookById(bookId)
    val state = viewModel.viewState.collectAsStateWithLifecycle()

    when (val currentState = state.value) {
        BookDetailMvi.ViewState.Error -> {}
        BookDetailMvi.ViewState.Loading -> CircularProgressIndicatorAtom()
        is BookDetailMvi.ViewState.Success -> BookDetailView(currentState.bookDetail)
        is BookDetailMvi.ViewState.BookDetailNotFound -> BookDetailNotFoundView(
            message = R.string.book_detail_not_found
        )
    }
}

@Composable
private fun BookDetailContent(book: Book, containerHeight: Dp) {
    Column {
        Title(puppy)
        ProfileProperty(stringResource(R.string.sex), puppy.sex)
        ProfileProperty(stringResource(R.string.age), puppy.age.toString())
        ProfileProperty(stringResource(R.string.personality), puppy.description)
    }
}

