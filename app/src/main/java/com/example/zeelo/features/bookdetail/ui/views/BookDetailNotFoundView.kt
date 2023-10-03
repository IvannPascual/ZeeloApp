package com.example.zeelo.features.bookdetail.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.ui.Dimens.spaceSmall

@Composable
fun BookDetailNotFoundView(message: Int) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = spaceSmall),
        text = stringResource(id = message),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
}