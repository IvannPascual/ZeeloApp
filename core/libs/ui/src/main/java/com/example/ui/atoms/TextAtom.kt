package com.example.ui.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TextAtom(content: String, emptyContent: String) {
    Text(
        text = content.ifEmpty { emptyContent },
        style = MaterialTheme.typography.bodySmall,
    )
}

