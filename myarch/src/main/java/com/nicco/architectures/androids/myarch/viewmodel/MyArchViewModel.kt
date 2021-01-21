package com.nicco.architectures.androids.myarch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nicco.architectures.androids.myarch.ui_contract.GreetingState

class MyArchViewModel : ViewModel() {

    private val _viewState by lazy { MutableLiveData<GreetingState>() }
    val viewState: LiveData<GreetingState> get() = _viewState
}