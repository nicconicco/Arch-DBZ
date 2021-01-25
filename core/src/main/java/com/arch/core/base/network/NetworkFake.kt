package com.arch.core.base.network

import com.arch.core.domain.MVCModel
import com.arch.core.domain.MVPModel
import com.arch.core.domain.MVVMModel
import io.reactivex.rxjava3.core.Single
import org.greenrobot.eventbus.EventBus


open class NetworkFake {

    fun createMVCInfos() =
        EventBus.getDefault().postSticky(MVCModel(url = "https://pt.wikipedia.org/wiki/MVC"))

    fun creaMVPInfos(): Single<MVPModel> {
        val success = MVPModel(url = "https://pt.wikipedia.org/wiki/Model-view-presenter")
        val single: Single<MVPModel> = Single.create { emitter ->
            emitter.onSuccess(success)
        }

        return single
    }

    fun createMVVMInfos(): MVVMModel {
        return MVVMModel(url = "https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel")
    }

    fun createMVPClean() : MVPModel = MVPModel(url = "https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html")
}