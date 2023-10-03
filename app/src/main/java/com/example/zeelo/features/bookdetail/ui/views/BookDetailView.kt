package com.example.zeelo.features.bookdetail.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zeelo.features.booklist.domain.model.Book


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