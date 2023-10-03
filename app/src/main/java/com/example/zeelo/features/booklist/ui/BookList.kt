package com.example.zeelo.features.booklist.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zeelo.features.booklist.domain.model.Book

@Composable
fun BooksList(
    books: List<Book>,
    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(books) { book ->
            BookCard(book.id, book.title, book.link, navigateToDetail)
        }
    }
}