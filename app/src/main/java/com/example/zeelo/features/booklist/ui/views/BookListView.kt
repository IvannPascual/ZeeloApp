package com.example.zeelo.features.booklist.ui.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zeelo.features.booklist.domain.model.Book

@Composable
fun BooksListView(
    books: List<Book>,
    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(books) { book ->
            BookCardView(book, navigateToDetail)
        }
    }
}