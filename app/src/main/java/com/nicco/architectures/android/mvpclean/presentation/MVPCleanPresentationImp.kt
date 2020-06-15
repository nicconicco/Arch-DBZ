package com.nicco.architectures.android.mvpclean.presentation

import com.nicco.architectures.android.base.BasePresenter
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MVPCleanPresentationImp @Inject constructor(
    private val mvpCleanUseCaseImp: MVPCleanUseCase
) : BasePresenter<MVPCleanPresentation.View>(), MVPCleanPresentation.Action {
    override fun loadMvpInfos() {
        fun showError(error: String){
            mView?.showProgress(false)
        }

        fun showInfos(mvpModel: MVPModel) {
            mView?.onLoadedInfosMvp(mvpModel)
            mView?.showProgress(false)
        }

        uiScope.launch {
            ioScope.async {
                return@async mvpCleanUseCaseImp.findInfos()
            }.await().fold(::showError, ::showInfos)
        }
    }
}