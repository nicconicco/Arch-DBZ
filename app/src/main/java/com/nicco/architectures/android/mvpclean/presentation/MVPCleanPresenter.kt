package com.nicco.architectures.android.mvpclean.presentation

import com.arch.core.base.Contract
import com.arch.core.domain.MVPModel

interface MVPCleanPresenter {

    interface View : Contract.View {
        fun showProgress(show: Boolean)
        fun onLoadedInfosMvp(mvpModel: MVPModel)
    }

    interface Action : Contract.Presenter<View> {
        fun loadMvpInfos()
    }
}