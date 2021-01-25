package com.nicco.architectures.android.mvp

import com.arch.core.base.BasePresenter
import com.nicco.architectures.android.mvp.providers.SchedulerProvider
import com.arch.core.base.network.NetworkFake
import com.arch.core.domain.MVPModel

class PresenterImp(
    private val networkFake: NetworkFake,
    private val scheduler: SchedulerProvider
) : BasePresenter<Presenter.View>(), Presenter.UserAction {

    override fun loadMvpInfos() {
        networkFake.creaMVPInfos()
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe(
                { mvpModel -> handleSuccess(mvpModel) },
                { handleError() })
    }

    private fun handleError() {
        mView?.showProgress(false)
    }

    private fun handleSuccess(mvpModel: MVPModel) {
        mView?.onLoadedInfosMvp(mvpModel)
        mView?.showProgress(false)
    }
}