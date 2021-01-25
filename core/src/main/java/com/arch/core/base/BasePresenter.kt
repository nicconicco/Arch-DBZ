package com.arch.core.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

abstract class BasePresenter<V : Contract.View> : Contract.Presenter<V>, BaseCoroutineScope() {
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