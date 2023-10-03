package com.example.zeelo.features.bookdetail.ui.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.domain.bookdetail.GetBookDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(private val getBookDetailUseCase: GetBookDetailUseCase) :
    ViewModel(),
    com.example.ui.mvi.BaseViewModel<BookDetailMvi.ViewAction, BookDetailMvi.ViewState, BookDetailMvi.ViewEffect> {

    override fun createInitialState(): BookDetailMvi.ViewState = BookDetailMvi.ViewState.Loading

    private val _viewState: MutableStateFlow<BookDetailMvi.ViewState> =
        MutableStateFlow(BookDetailMvi.ViewState.Loading)
    override val viewState: StateFlow<BookDetailMvi.ViewState> = _viewState.asStateFlow()

    private val _viewAction: MutableSharedFlow<BookDetailMvi.ViewAction> = MutableSharedFlow()
    override val viewAction: SharedFlow<BookDetailMvi.ViewAction>
        get() = _viewAction

    private val _viewEffect: MutableSharedFlow<BookDetailMvi.ViewEffect> =
        MutableSharedFlow()
    override val viewEffect: SharedFlow<BookDetailMvi.ViewEffect>
        get() = _viewEffect.asSharedFlow()


    fun getBookById(id: Long) {
        viewModelScope.launch {
            getBookDetailUseCase.invoke(id).collectLatest { latestBook ->
                if(latestBook != null) {
                    _viewState.value = BookDetailMvi.ViewState.Success(latestBook)
                } else {
                    _viewState.value = BookDetailMvi.ViewState.BookDetailNotFound
                }
            }
        }
    }

    override fun subscribeEvents() {

    }

    override fun onHandleViewAction(viewAction: BookDetailMvi.ViewAction) {

    }
}