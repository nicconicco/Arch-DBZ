package com.nicco.architectures.android.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

abstract class BasePresenter<V : Contract.View> : Contract.Presenter<V>, BaseCorotuineScope() {
    protected var mView: V? = null

    override fun attach(view: V) {
        this.mView = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detach() {
        onCleared()
        this.mView = null
    }
}