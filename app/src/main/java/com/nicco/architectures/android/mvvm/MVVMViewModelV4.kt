package com.nicco.architectures.android.mvvm

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nicco.architectures.android.MyApp
import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.base.SingleLiveEvent
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

sealed class ViewState {
    data class loading(val load: Boolean) : ViewState()
    data class showInfosMVVm(val mvvm: MVVMModel) : ViewState()
    data class erro(val erroType: String) : ViewState()
}

class MVVMViewModelV4(val networkUseCase: NetworkUseCase) : BaseViewModelV4() {
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
            return@async networkUseCase.execute()
        }.await().fold(::showError, ::showInfos)
    }
}

interface NetworkUseCase {
    suspend fun execute() : Either<String, MVVMModel>
}

open class NetworkUseCaseImp: NetworkUseCase {
    override suspend fun execute(): Either<String, MVVMModel> {
        return try {
            Either.Right(MVVMModel(url = "ok"))
        } catch (e: Exception) {
            Either.Left("nok")
        }
    }
}

open class BaseViewModelV4 :
    AndroidViewModel(MyApp()), CoroutineScope {
    val job = SupervisorJob()

    val uiScope = CoroutineScope(Dispatchers.Main + job)
    val ioScope = CoroutineScope(Dispatchers.IO + job)

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}