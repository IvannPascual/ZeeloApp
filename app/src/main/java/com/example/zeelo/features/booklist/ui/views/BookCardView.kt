package com.example.zeelo.features.booklist.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.common.domain.booklist.model.Book
import com.common.domain.booklist.model.defaultImageBook
import com.example.ui.Dimens.imageSizeList
import com.example.zeelo.R
import com.example.ui.Dimens.spaceSmall
import com.example.ui.Dimens.spaceTiny
import com.example.ui.atoms.TextAtom

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

            Image(
                painter = rememberAsyncImagePainter(model = book.link.ifEmpty { defaultImageBook }),
                contentDescription = "Book Cover",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imageSizeList)
                    .padding(spaceSmall)
            )

            Column(Modifier.padding(spaceSmall)) {
                TextAtom(
                    content = book.title,
                    stringResource(id = R.string.book_with_no_title)
                )
                Spacer(modifier = Modifier.padding(top = spaceTiny))
                TextAtom(
                    content = book.author,
                    stringResource(id = R.string.book_with_no_author)
                )
                Spacer(modifier = Modifier.padding(top = spaceTiny))
                TextAtom(
                    content = book.link,
                    stringResource(id = R.string.book_with_no_link)
                )
            }
        }
    }
}