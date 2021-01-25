package com.nicco.architectures.android.mvp

import com.arch.core.base.Contract
import com.arch.core.domain.MVPModel

interface Presenter {

    interface View : Contract.View {
        fun showProgress(show: Boolean)
        fun onLoadedInfosMvp(mvpModel: MVPModel)
    }

    interface UserAction : Contract.Presenter<View> {
        fun loadMvpInfos()
    }
}