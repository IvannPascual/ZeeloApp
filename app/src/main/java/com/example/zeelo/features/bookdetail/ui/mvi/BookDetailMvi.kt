package com.example.zeelo.features.bookdetail.ui.mvi

import com.common.domain.booklist.model.Book
import com.example.ui.mvi.UIAction
import com.example.ui.mvi.UIEffect
import com.example.ui.mvi.UIState

interface BookDetailMvi {

    sealed interface ViewState : com.example.ui.mvi.UIState {
        data object Loading : ViewState
        data class Success(val bookDetail: Book) : ViewState
        data object BookDetailNotFound : ViewState
        data object Error : ViewState
    }

    sealed interface ViewAction : com.example.ui.mvi.UIAction {
    }

    sealed interface ViewEffect : com.example.ui.mvi.UIEffect {
        data object None : ViewEffect
    }
}