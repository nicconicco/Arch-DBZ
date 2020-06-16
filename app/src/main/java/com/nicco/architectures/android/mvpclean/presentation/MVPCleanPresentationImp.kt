package com.nicco.architectures.android.mvpclean.presentation

import android.util.Log
import com.nicco.architectures.android.base.BasePresenter
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class MVPCleanPresentationImp @Inject constructor(
    private val mvpCleanUseCaseImp: MVPCleanUseCase
) : BasePresenter<MVPCleanPresentation.View>(), MVPCleanPresentation.Action {
    override fun loadMvpInfos() {
        try {
            uiScope.launch {
                getInfos()
            }
        } catch (e: Exception) {
            Log.e("Error", "${e.message}")
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
        try {
            ioScope.async {
                return@async mvpCleanUseCaseImp.findInfos()
            }.await().fold(::showError, ::showInfos)
        } catch (e: Exception) {
            Log.e("Error", "${e.message}")
        }
    }
}