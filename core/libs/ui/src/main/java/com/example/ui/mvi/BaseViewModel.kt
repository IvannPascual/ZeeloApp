package com.example.ui.mvi

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface BaseViewModel<ViewAction, ViewState, ViewEffect> {
    fun createInitialState(): ViewState

    val viewState: StateFlow<ViewState>

    val viewAction: SharedFlow<ViewAction>

    val viewEffect: SharedFlow<ViewEffect>

    fun subscribeEvents()

    fun onHandleViewAction(viewAction: ViewAction)
}