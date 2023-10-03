package com.example.zeelo.features.booklist.ui.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.domain.booklist.GetBooksUseCase
import com.example.ui.mvi.BaseViewModel
import com.example.zeelo.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
) :
    ViewModel(),
    BaseViewModel<BookListMvi.ViewAction, BookListMvi.ViewState, BookListMvi.ViewEffect> {

    override fun createInitialState(): BookListMvi.ViewState = BookListMvi.ViewState.Loading

    private val _viewState: MutableStateFlow<BookListMvi.ViewState> =
        MutableStateFlow(BookListMvi.ViewState.Loading)
    override val viewState: StateFlow<BookListMvi.ViewState> = _viewState.asStateFlow()

    private val _viewAction: MutableSharedFlow<BookListMvi.ViewAction> = MutableSharedFlow()
    override val viewAction: SharedFlow<BookListMvi.ViewAction>
        get() = _viewAction

    private val _viewEffect: MutableSharedFlow<BookListMvi.ViewEffect> =
        MutableSharedFlow()
    override val viewEffect: SharedFlow<BookListMvi.ViewEffect>
        get() = _viewEffect.asSharedFlow()


    init {
        viewModelScope.launch {
            getBooksUseCase.invoke().collect {
                if(it.isEmpty()) {
                    _viewState.value = BookListMvi.ViewState.EmptyData(R.string.no_books_available)
                } else {
                    _viewState.value = BookListMvi.ViewState.Success(books = it)
                }
            }
        }
    }

    override fun subscribeEvents() {

    }

    override fun onHandleViewAction(viewAction: BookListMvi.ViewAction) {
        viewModelScope.launch {
            when (viewAction) {
                is BookListMvi.ViewAction.GoToBookDetail -> _viewEffect.emit(
                    BookListMvi.ViewEffect.GoToBookDetail(
                        id = viewAction.id
                    )
                )
            }
        }
    }

}
