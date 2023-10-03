package com.example.zeelo.features.addnewbook.ui.mvi

import com.common.domain.booklist.model.Book
import com.example.ui.mvi.UIAction
import com.example.ui.mvi.UIEffect
import com.example.ui.mvi.UIState

interface AddNewBookMvi {

    sealed interface ViewState : UIState {
        data object Loading : ViewState
        data object Success : ViewState
        data object Error : ViewState
    }

    sealed interface ViewAction : UIAction {
        data class AddNewBook(val book: Book) : ViewAction
    }

    sealed interface ViewEffect : UIEffect {
        data object None : ViewEffect
        data object BookAdded : ViewEffect
    }
}
