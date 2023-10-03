package com.example.zeelo.features.bookdetail.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.common.domain.booklist.model.Book
import com.common.domain.booklist.model.defaultImageBook
import com.example.ui.Dimens.imageSizeDetail
import com.example.ui.Dimens.spaceSmall
import com.example.ui.Dimens.spaceVeryBig
import com.example.ui.atoms.TitleAtom


@Composable
fun BookDetailView(book: Book, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = spaceVeryBig)
            .fillMaxSize()
    ) {
        val painter =
            rememberAsyncImagePainter(model = book.link.ifEmpty { defaultImageBook })
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .width(imageSizeDetail)
                .height(imageSizeDetail)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(text = "Title", style = MaterialTheme.typography.titleMedium)
        TitleAtom(
            text = book.title,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(text = "Link", style = MaterialTheme.typography.titleMedium)
        TitleAtom(
            text = book.link,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(
            text = "Author",
            style = MaterialTheme.typography.titleMedium
        )
        TitleAtom(
            text = book.author,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(text = "Price", style = MaterialTheme.typography.titleMedium)
        TitleAtom(
            text = book.price.toString(),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

