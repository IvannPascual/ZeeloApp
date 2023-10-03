package com.example.zeelo.features.addnewbook.ui.mvi

import com.example.zeelo.core.libs.ui.mvi.UIAction
import com.example.zeelo.core.libs.ui.mvi.UIEffect
import com.example.zeelo.core.libs.ui.mvi.UIState
import com.example.zeelo.features.booklist.domain.model.Book

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
