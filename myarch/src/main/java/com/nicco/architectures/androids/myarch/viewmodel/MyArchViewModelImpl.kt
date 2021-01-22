package com.nicco.architectures.androids.myarch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicco.architectures.androids.myarch.ui_contract.FetchStatus
import com.nicco.architectures.androids.myarch.ui_contract.GreetingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class MyArchViewModel : ViewModel() {
    abstract val viewState: StateFlow<GreetingState>
}

class MyArchViewModelImpl : MyArchViewModel() {

    override val viewState = MutableStateFlow(GreetingState(
        FetchStatus.Idle,
        greeting = null,
        error = null
    ))

    fun doSomething() {
        viewModelScope.launch {
            viewState.emit(GreetingState(
                FetchStatus.Success,
                greeting = "",
                error = ""
            ))
        }
    }
}