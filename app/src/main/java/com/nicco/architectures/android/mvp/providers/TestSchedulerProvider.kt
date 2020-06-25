package com.nicco.architectures.android.mvp.providers

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.TestScheduler

class TestSchedulerProvider(private val testSchedulerProvider: TestScheduler):
    SchedulerProvider {
    override fun io(): Scheduler {
        return testSchedulerProvider
    }

    override fun ui(): Scheduler {
        return testSchedulerProvider
    }
}