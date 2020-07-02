package com.nicco.architectures.android.mvvmclean.presentation

import androidx.hilt.lifecycle.ViewModelInject
import com.nicco.architectures.android.mvvm.BaseViewModel
import com.nicco.architectures.android.mvvm.MVVMModel
import com.nicco.architectures.android.mvvmclean.usecase.MVVMCleanUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

inline val <T> T.exaustive get() = this

sealed class ViewState {
    object Idle : ViewState()
    data class Loading(val load: Boolean) : ViewState()
    data class SuccessInfosMVVM(val mvvm: MVVMModel) : ViewState()
    data class Error(val erroType: String) : ViewState()
}

@ExperimentalCoroutinesApi
class MVVMViewModel @ViewModelInject constructor(
    private val mvvmCleanUseCase: MVVMCleanUseCase
) : BaseViewModel(Dispatchers.Main, Dispatchers.IO) {

    private val _state by lazy { MutableStateFlow<ViewState>(ViewState.Idle) }
    val state: StateFlow<ViewState> get() = _state

    fun findInfosMVVM() {
        _state.value = ViewState.Loading(true)

        uiScope.launch {
            getInfos()
        }
    }

    private suspend fun getInfos() {
        fun showError(erro: String) {
            _state.value = ViewState.Error(erro)
        }

        fun sucessInfos(mvvmModel: MVVMModel) {
            _state.value = ViewState.Loading(false)

            _state.value = try {
                ViewState.SuccessInfosMVVM(mvvmModel)
            } catch (e: Exception) {
                ViewState.Error(e.message ?: "Exception")
            }
        }

        ioScope.async {
            return@async mvvmCleanUseCase.findInfos()
        }.await().fold(::showError, ::sucessInfos)
    }
}