package com.nicco.architectures.android.mvpclean.presentation

import com.nicco.architectures.android.base.Contract
import com.nicco.architectures.android.mvp.MVPModel

interface MVPCleanPresenter {

    interface View : Contract.View {
        fun showProgress(show: Boolean)
        fun onLoadedInfosMvp(mvpModel: MVPModel)
    }

    interface Action : Contract.Presenter<View> {
        fun loadMvpInfos()
    }
}