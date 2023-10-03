package com.example.zeelo.features.addnewbook.ui.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.domain.addnewbook.AddNewBookUseCase
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
class AddNewBookViewModel @Inject constructor(
    private val addNewBookUseCase: AddNewBookUseCase
) :
    ViewModel(),
    com.example.ui.mvi.BaseViewModel<AddNewBookMvi.ViewAction, AddNewBookMvi.ViewState, AddNewBookMvi.ViewEffect> {

    override fun createInitialState(): AddNewBookMvi.ViewState = AddNewBookMvi.ViewState.Loading

    private val _viewState: MutableStateFlow<AddNewBookMvi.ViewState> =
        MutableStateFlow(AddNewBookMvi.ViewState.Loading)
    override val viewState: StateFlow<AddNewBookMvi.ViewState> = _viewState.asStateFlow()

    private val _viewAction: MutableSharedFlow<AddNewBookMvi.ViewAction> = MutableSharedFlow()
    override val viewAction: SharedFlow<AddNewBookMvi.ViewAction>
        get() = _viewAction

    private val _viewEffect: MutableSharedFlow<AddNewBookMvi.ViewEffect> =
        MutableSharedFlow()
    override val viewEffect: SharedFlow<AddNewBookMvi.ViewEffect>
        get() = _viewEffect.asSharedFlow()


    init {
        subscribeEvents()
    }

    override fun subscribeEvents() {
        viewModelScope.launch {
        }
    }

    override fun onHandleViewAction(viewAction: AddNewBookMvi.ViewAction) {
        viewModelScope.launch {
            when (viewAction) {
                is AddNewBookMvi.ViewAction.AddNewBook -> {
                    addNewBookUseCase.invoke(viewAction.book)
                    _viewEffect.emit(AddNewBookMvi.ViewEffect.BookAdded)
                }
            }
        }
    }

}