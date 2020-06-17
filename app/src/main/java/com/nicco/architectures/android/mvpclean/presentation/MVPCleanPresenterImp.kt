package com.nicco.architectures.android.mvpclean.presentation

import com.nicco.architectures.android.base.BasePresenter
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MVPCleanPresenterImp (
    private val mvpCleanUseCaseImp: MVPCleanUseCase
) : BasePresenter<MVPCleanPresenter.View>(), MVPCleanPresenter.Action {
    override fun loadMvpInfos() {
        uiScope.launch {
            getInfos()
        }
    }

    fun showError(error: String) {
        mView?.showProgress(false)
    }

    fun showInfos(mvpModel: MVPModel) {
        mView?.onLoadedInfosMvp(mvpModel)
        mView?.showProgress(false)
    }

    private suspend fun getInfos() {
        ioScope.async {
            return@async mvpCleanUseCaseImp.findInfos()
        }.await().fold(::showError, ::showInfos)
    }
}