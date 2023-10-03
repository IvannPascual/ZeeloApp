package com.example.zeelo.features.addnewbook.ui.mvi

import com.example.ui.mvi.UIAction
import com.example.ui.mvi.UIEffect
import com.example.ui.mvi.UIState

interface AddNewBookMvi {

    sealed interface ViewState : com.example.ui.mvi.UIState {
        data object Loading : ViewState
        data object Success : ViewState
        data object Error : ViewState
    }

    sealed interface ViewAction : com.example.ui.mvi.UIAction {
        data class AddNewBook(val book: com.common.domain.booklist.model.Book) : ViewAction
    }

    sealed interface ViewEffect : com.example.ui.mvi.UIEffect {
        data object None : ViewEffect
        data object BookAdded : ViewEffect
    }
}
