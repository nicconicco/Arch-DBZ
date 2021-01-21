package com.nicco.architectures.androids.myarch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nicco.architectures.androids.myarch.ui_contract.FetchStatus
import com.nicco.architectures.androids.myarch.ui_contract.GreetingState

abstract class MyViewModel : ViewModel() {
    abstract val viewState: LiveData<GreetingState>
}

class MyArchViewModel() : MyViewModel() {

    override val viewState = MutableLiveData<GreetingState>()

    fun doSomething() {
        //do something
        viewState.value = GreetingState(
            FetchStatus.Success,
            greeting = "",
            error = ""
        )
    }
}