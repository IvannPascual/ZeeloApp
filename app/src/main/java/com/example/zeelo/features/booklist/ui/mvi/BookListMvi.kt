package com.example.zeelo.features.booklist.ui.mvi

import androidx.annotation.StringRes
import com.example.zeelo.core.libs.ui.mvi.UIAction
import com.example.zeelo.core.libs.ui.mvi.UIEffect
import com.example.zeelo.core.libs.ui.mvi.UIState
import com.example.zeelo.features.booklist.domain.model.Book


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
