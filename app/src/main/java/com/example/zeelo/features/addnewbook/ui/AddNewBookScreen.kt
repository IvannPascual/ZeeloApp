package com.example.zeelo.features.addnewbook.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeelo.common.extensions.toDoubleOrZero
import com.example.zeelo.features.addnewbook.ui.mvi.AddNewBookMvi
import com.example.zeelo.features.addnewbook.ui.mvi.AddNewBookViewModel
import com.example.zeelo.features.booklist.domain.model.Book
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AddNewBookScreen(
    viewModel: AddNewBookViewModel = hiltViewModel(),
    navBack: () -> Unit

) {

    val focusManager = LocalFocusManager.current

    var link by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    collectViewEffects(viewModel, navBack)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = link,
            onValueChange = { link = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text("Link") },
        )
        Spacer(Modifier.padding(top = 16.dp))
        TextField(
            value = title,
            onValueChange = { title = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text("Title") },
        )

        Spacer(Modifier.padding(top = 16.dp))
        TextField(
            value = author,
            onValueChange = { author = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text("Author") },
        )

        Spacer(Modifier.padding(top = 16.dp))
        TextField(
            value = price,
            onValueChange = { price = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text("Price") },
        )

        Button(onClick = {
            viewModel.onHandleViewAction(
                AddNewBookMvi.ViewAction.AddNewBook(
                    Book(
                        id = System.currentTimeMillis(),
                        title = title,
                        link = link,
                        author = author,
                        price = price.toDoubleOrZero()
                    )
                )
            )
        }) {
            Text("Add new Book")
        }
    }
}

@Composable
private fun collectViewEffects(
    viewModel: AddNewBookViewModel,
    navBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.viewEffect.collectLatest {
            when (it) {
                is AddNewBookMvi.ViewEffect.BookAdded -> {
                    navBack.invoke()
                }

                AddNewBookMvi.ViewEffect.None -> {}
            }
        }
    }
}