package com.nicco.architectures.android.mvp.providers

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class AppSchedulerProvider(val io: Scheduler, val ui: Scheduler):
    SchedulerProvider {
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return ui
    }
}