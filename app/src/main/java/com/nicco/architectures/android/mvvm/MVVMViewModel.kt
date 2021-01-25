package com.nicco.architectures.android.mvvm

import androidx.lifecycle.LiveData
import com.arch.core.base.SingleLiveEvent
import com.arch.core.domain.MVVMModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

sealed class ViewState {
    data class loading(val load: Boolean) : ViewState()
    data class showInfosMVVm(val mvvm: MVVMModel) : ViewState()
    data class erro(val erroType: String) : ViewState()
}

class MVVMViewModel(
    val networkProvider: NetworkProvider,
    val mainThread: CoroutineContext,
    val inOutThread: CoroutineContext
) : BaseViewModel(mainThread, inOutThread) {
    private val _viewState by lazy { SingleLiveEvent<ViewState>() }
    val viewState: LiveData<ViewState> get() = _viewState

    fun findInfosMVVM() {
        _viewState.value = ViewState.loading(true)

        uiScope.launch {
            getInfosNetwork()
        }
    }

    private suspend fun getInfosNetwork() {
        fun showError(erro: String) {
            _viewState.value = ViewState.erro(erro)
        }

        fun showInfos(mvvmModel: MVVMModel) {
            _viewState.value = ViewState.loading(false)
            _viewState.value = ViewState.showInfosMVVm(mvvmModel)
        }

        ioScope.async {
            return@async networkProvider.findInfos()
        }.await().fold(::showError, ::showInfos)
    }
}