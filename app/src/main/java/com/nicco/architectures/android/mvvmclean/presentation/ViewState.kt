package com.nicco.architectures.android.mvvmclean.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.nicco.architectures.android.base.SingleLiveEvent
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCase
import com.nicco.architectures.android.mvvm.BaseViewModel
import com.nicco.architectures.android.mvvm.MVVMModel
import com.nicco.architectures.android.mvvmclean.usecase.MVVMCleanUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

sealed class ViewState {
    data class loading(val load: Boolean) : ViewState()
    data class showInfosMVVm(val mvvm: MVVMModel) : ViewState()
    data class erro(val erroType: String) : ViewState()
}

class MVVMViewModel @ViewModelInject constructor(
    private val mvvmCleanUseCase: MVVMCleanUseCase
) : BaseViewModel() {
    private val _viewState by lazy { SingleLiveEvent<ViewState>() }
    val viewState: LiveData<ViewState> get() = _viewState

    fun findInfosMVVM() {
        _viewState.value = ViewState.loading(true)

        uiScope.launch {
            getInfos()
        }
    }

    private suspend fun getInfos() {
        fun showError(erro: String) {
            _viewState.value = ViewState.erro(erro)
        }

        fun showInfos(mvvmModel: MVVMModel) {
            _viewState.value = ViewState.loading(false)
            _viewState.value = ViewState.showInfosMVVm(mvvmModel)
        }

        ioScope.async {
            return@async mvvmCleanUseCase.findInfos()
        }.await().fold(::showError, ::showInfos)
    }
}