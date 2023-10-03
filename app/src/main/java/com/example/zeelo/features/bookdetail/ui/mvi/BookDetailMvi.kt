package com.example.zeelo.features.bookdetail.ui.mvi

import com.example.zeelo.core.libs.ui.mvi.UIAction
import com.example.zeelo.core.libs.ui.mvi.UIEffect
import com.example.zeelo.core.libs.ui.mvi.UIState
import com.example.zeelo.features.booklist.domain.model.Book

interface BookDetailMvi {

    sealed interface ViewState : UIState {
        data object Loading : ViewState
        data class Success(val bookDetail: Book) : ViewState
        data object BookDetailNotFound : ViewState
        data object Error : ViewState
    }

    sealed interface ViewAction : UIAction {
    }

    sealed interface ViewEffect : UIEffect {
        data object None : ViewEffect
    }
}