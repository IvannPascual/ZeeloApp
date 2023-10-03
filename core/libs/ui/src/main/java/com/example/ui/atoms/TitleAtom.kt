package com.example.ui.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.Dimens.spaceSmall

@Composable
fun TitleAtom(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.padding(start = spaceSmall, end = spaceSmall, bottom = spaceSmall)) {
        Text(
            text = text,
            modifier = modifier,
            fontWeight = FontWeight.Bold,
            style = style
        )
    }
}