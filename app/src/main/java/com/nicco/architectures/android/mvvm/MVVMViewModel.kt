package com.nicco.architectures.android.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nicco.architectures.android.network.CoroutineNetworkFake

sealed class State<out T> {
    data class Success<out T>(val result: T) : State<T>()
    data class Error<out T>(val msg: String) : State<T>()
    data class Loading<out T>(val loading: Boolean) : State<T>()
}

class MVVMViewModel(val coroutineNetworkFake: CoroutineNetworkFake) : ViewModel() {

    private val _actionView = MutableLiveData<State<MVVMModel>>()
    val actionView: LiveData<State<MVVMModel>>
        get() = _actionView

    init {
    }

    fun getInfos() {
        coroutineNetworkFake.execute {
            _actionView.postValue(State.Loading(true))

            onComplete {
                _actionView.postValue(State.Loading(false))
                _actionView.postValue(State.Success(it))
            }
            onCancel {
                _actionView.postValue(State.Loading(false))
                _actionView.postValue(State.Error(it.localizedMessage))
            }
            onError { it ->
                _actionView.postValue(State.Loading(false))
                it.message?.let {
                    _actionView.postValue(State.Error(it))
                }
            }
        }
    }
}