package com.example.zeelo.features.addnewbook.ui

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeelo.R
import com.example.zeelo.common.extensions.toDoubleOrZero
import com.example.ui.Dimens.spaceSmall
import com.example.zeelo.features.addnewbook.ui.mvi.AddNewBookMvi
import com.example.zeelo.features.addnewbook.ui.mvi.AddNewBookViewModel
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
        modifier = Modifier.padding(spaceSmall),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text(stringResource(id = R.string.add_book_title)) },
        )
       
        Spacer(Modifier.padding(top = spaceSmall))
        TextField(
            value = link,
            onValueChange = { link = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text(stringResource(id = R.string.add_book_link)) },
        )

        Spacer(Modifier.padding(top = spaceSmall))
        TextField(
            value = author,
            onValueChange = { author = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text(stringResource(id = R.string.add_book_author)) },
        )

        Spacer(Modifier.padding(top = spaceSmall))
        TextField(
            value = price,
            onValueChange = { price = it },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text(stringResource(id = R.string.add_book_price)) },
        )
        Spacer(Modifier.padding(top = spaceSmall))
        Button(onClick = {
            viewModel.onHandleViewAction(
                AddNewBookMvi.ViewAction.AddNewBook(
                    com.common.domain.booklist.model.Book(
                        id = System.currentTimeMillis(),
                        title = title,
                        link = link,
                        author = author,
                        price = price.toDoubleOrZero()
                    )
                )
            )
        }) {
            Text(stringResource(id = R.string.add_new_book))
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