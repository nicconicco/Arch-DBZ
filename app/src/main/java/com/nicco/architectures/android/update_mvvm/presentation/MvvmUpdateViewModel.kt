package com.nicco.architectures.android.update_mvvm.presentation

import android.util.Log
import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicco.architectures.android.base.SingleLiveEvent
import com.nicco.architectures.android.mvvmclean.presentation.ViewState
import com.nicco.architectures.android.update_mvvm.usecase.UseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

sealed class UpdateAction {
    open class Success(val url: String) : UpdateAction()
    open class Error(val msg: String) : UpdateAction()
    object HideLoading : UpdateAction()
    object ShowLoading : UpdateAction()
    object Idle : UpdateAction()
}

@ExperimentalCoroutinesApi
class MvvmUpdateViewModel(
    private val scopeIO: CoroutineContext,
    private val useCaseImp: UseCase
) : ViewModel() {

    private val _state by lazy { SingleLiveEvent<UpdateAction>() }
    val state: LiveData<UpdateAction> get() = _state

    @UiThread
    fun getMvvmUpdate() {
        viewModelScope.launch(
            scopeIO
        ) {
            try {
                _state.postValue(UpdateAction.ShowLoading)
                fun errorState(error: String) {
                    _state.postValue(UpdateAction.HideLoading)
                    _state.postValue(UpdateAction.Error(error))
                }

                fun successState(success: String) {
                    _state.postValue(UpdateAction.HideLoading)
                    _state.postValue(UpdateAction.Success(success))
                }

                useCaseImp.getMvvmUpdate().fold(::errorState, ::successState)
            } catch (ioe: IOException) {
                Log.e(IOException::class.java.name, ioe.message.toString())
                _state.postValue(UpdateAction.HideLoading)
            } catch (e: Exception) {
                Log.e(Exception::class.java.name, e.message.toString())
                _state.postValue(UpdateAction.HideLoading)
            }
        }
    }
}