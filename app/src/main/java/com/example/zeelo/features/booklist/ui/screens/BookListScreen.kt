package com.example.zeelo.features.booklist.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.Dimens.spaceSmall
import com.example.ui.atoms.CircularProgressIndicatorAtom
import com.example.zeelo.features.booklist.ui.BookListTestTags.noBooksErrorTestTag
import com.example.zeelo.features.booklist.ui.mvi.BookListMvi
import com.example.zeelo.features.booklist.ui.mvi.BookListViewModel
import com.example.zeelo.features.booklist.ui.views.BooksListView

@Composable
fun BookListScreen(
    viewModel: BookListViewModel = hiltViewModel(),
    navigateToDetail: (Long) -> Unit
) {

    val state = viewModel.viewState.collectAsStateWithLifecycle()
    val viewEffect =
        viewModel.viewEffect.collectAsStateWithLifecycle(initialValue = BookListMvi.ViewEffect.None)

    collectViewStates(state, viewModel)
    collectViewEffects(viewEffect, navigateToDetail)
}

@Composable
private fun collectViewStates(
    state: State<BookListMvi.ViewState>,
    viewModel: BookListViewModel
) {
    when (val currentState = state.value) {
        BookListMvi.ViewState.Error -> {
            Text(text = "No books available", Modifier.testTag(noBooksErrorTestTag))
        }

        BookListMvi.ViewState.Loading -> CircularProgressIndicatorAtom()
        is BookListMvi.ViewState.Success ->
            BooksListView(
                currentState.books,
                navigateToDetail = {
                    viewModel.onHandleViewAction(
                        BookListMvi.ViewAction.GoToBookDetail(it)
                    )
                }
            )

        is BookListMvi.ViewState.EmptyData -> Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = spaceSmall),
            text = stringResource(id = currentState.message),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun collectViewEffects(
    viewEffect: State<BookListMvi.ViewEffect>,
    navigateToDetail: (Long) -> Unit
) {
    when (val effect = viewEffect.value) {
        is BookListMvi.ViewEffect.GoToBookDetail -> navigateToDetail.invoke(effect.id)
        BookListMvi.ViewEffect.None -> {}
    }
}




