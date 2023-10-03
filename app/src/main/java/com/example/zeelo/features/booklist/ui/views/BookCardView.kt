package com.example.zeelo.features.booklist.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.zeelo.R
import com.example.zeelo.core.libs.ui.Dimens.spaceSmall
import com.example.zeelo.core.libs.ui.Dimens.spaceTiny
import com.example.zeelo.core.libs.ui.views.atoms.TextAtom
import com.example.zeelo.features.booklist.domain.model.Book

@Composable
fun BookCardView(
    book: Book,
    navigateToDetail: (Long) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(spaceTiny)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navigateToDetail.invoke(book.id)
            },
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(Modifier.padding(spaceSmall)) {
                TextAtom(content = book.title, stringResource(id = R.string.book_with_no_title))
                Spacer(modifier = Modifier.padding(top = spaceTiny))
                TextAtom(content = book.author, stringResource(id = R.string.book_with_no_author))
                Spacer(modifier = Modifier.padding(top = spaceTiny))
                TextAtom(content = book.link, stringResource(id = R.string.book_with_no_link))
            }
        }
    }
}