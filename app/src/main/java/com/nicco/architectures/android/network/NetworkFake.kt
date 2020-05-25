package com.nicco.architectures.android.network

import com.nicco.architectures.android.mvc.MVCModel
import com.nicco.architectures.android.mvp.MVPModel
import io.reactivex.rxjava3.core.Single
import org.greenrobot.eventbus.EventBus


open class NetworkFake {

    fun createMVCInfos() =
        EventBus.getDefault().postSticky(MVCModel(url = "https://pt.wikipedia.org/wiki/MVC"))

    fun creaMVPInfos(): MVPModel =
        MVPModel(url = "https://pt.wikipedia.org/wiki/Model-view-presenter")

    fun createItem(): Single<MVPModel> {
        val success = MVPModel(url = "https://pt.wikipedia.org/wiki/Model-view-presenter")
        val single: Single<MVPModel> = Single.create { emitter ->
            emitter.onSuccess(success)
        }

        return single
    }
}