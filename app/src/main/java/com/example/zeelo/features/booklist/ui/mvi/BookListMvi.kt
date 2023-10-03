package com.example.zeelo.features.booklist.ui.mvi

import androidx.annotation.StringRes
import com.common.domain.booklist.model.Book
import com.example.ui.mvi.UIAction
import com.example.ui.mvi.UIEffect
import com.example.ui.mvi.UIState


interface BookListMvi {

    sealed interface ViewState : UIState {
        data object Loading : ViewState
        data class Success(val books: List<Book>) : ViewState
        data class EmptyData(@StringRes val message: Int) : ViewState
        data object Error : ViewState
    }

    sealed interface ViewAction : UIAction {
        data class GoToBookDetail(val id: Long) : ViewAction
    }

    sealed interface ViewEffect : UIEffect {
        data object None : ViewEffect
        data class GoToBookDetail(val id: Long) : ViewEffect
    }
}
