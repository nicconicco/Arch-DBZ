package com.nicco.architectures.androids.myarch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicco.architectures.androids.myarch.ui_contract.ViewStatus
import com.nicco.architectures.androids.myarch.ui_contract.ArchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class MyArchViewModel : ViewModel() {
    abstract val viewState: StateFlow<ArchState>
}

class MyArchViewModelImpl : MyArchViewModel() {
    override val viewState = MutableStateFlow(ArchState(
        ViewStatus.Idle,
        gokuImg = null,
        error = null
    ))

    fun doSomething() {
        viewModelScope.launch {
            viewState.emit(ArchState(
                ViewStatus.Success,
                gokuImg = "",
                error = ""
            ))
        }
    }
}