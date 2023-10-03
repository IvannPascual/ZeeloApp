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
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.zeelo.core.libs.ui.Dimens.imageSize
import com.example.zeelo.core.libs.ui.Dimens.spaceSmall
import com.example.zeelo.core.libs.ui.Dimens.spaceVeryBig
import com.example.zeelo.core.libs.ui.views.atoms.TitleAtom
import com.example.zeelo.features.booklist.domain.model.Book


@Composable
fun BookDetailView(book: Book, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = spaceVeryBig)
            .fillMaxSize()
    ) {
        val painter =
            rememberAsyncImagePainter(model = book.link)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .width(imageSize)
                .height(imageSize)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(text = "Title",  style = MaterialTheme.typography.titleMedium)
        TitleAtom(text = book.title,  style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(text = "Link",  style = MaterialTheme.typography.titleMedium)
        TitleAtom(text = book.link,  style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(text = "Author",  style = MaterialTheme.typography.titleMedium)
        TitleAtom(text = book.author,  style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.padding(top = spaceSmall))
        TitleAtom(text = "Price",  style = MaterialTheme.typography.titleMedium)
        TitleAtom(text = book.price.toString(),  style = MaterialTheme.typography.titleSmall)
    }
}

