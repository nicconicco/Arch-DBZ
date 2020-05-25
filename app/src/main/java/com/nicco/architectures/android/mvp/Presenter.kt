package com.nicco.architectures.android.mvp

import com.nicco.architectures.android.base.Contract

interface Presenter {

    interface View : Contract.View {
        fun showProgress(show: Boolean)
        fun onLoadedInfosMvp(mvpModel: MVPModel)
    }

    interface UserAction : Contract.Presenter<View> {
        fun loadMvpInfos()
    }
}