package com.example.zeelo.features.booklist.ui.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.common.domain.booklist.model.Book
import com.example.ui.Dimens.spaceSmall
import com.example.zeelo.features.booklist.ui.BookListTestTags.bookListViewTestTag

@Composable
fun BooksListView(
    books: List<Book>,
    navigateToDetail: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth().testTag(bookListViewTestTag),
        contentPadding = PaddingValues(spaceSmall)
    ) {
        items(books) { book ->
            BookCardView(book, navigateToDetail)
        }
    }
}