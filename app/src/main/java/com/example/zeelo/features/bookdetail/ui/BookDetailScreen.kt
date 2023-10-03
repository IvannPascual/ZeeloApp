package com.example.zeelo.features.bookdetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.zeelo.R
import com.example.zeelo.core.libs.ui.views.CircularProgressIndicatorAtom
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
        is BookDetailMvi.ViewState.BookDetailNotFound -> BookDetailNotFound(
            message = R.string.book_detail_not_found
        )
    }
}

@Composable
fun BookDetailView(book: Book, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 200.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Title:  ${book.title}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Link: ${book.link}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Author: ${book.author}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Price: ${book.price}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun BookDetailNotFound(message: Int) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        text = stringResource(id = message),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
}
