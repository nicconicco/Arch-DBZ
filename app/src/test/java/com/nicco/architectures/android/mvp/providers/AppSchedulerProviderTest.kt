package com.nicco.architectures.android.mvp.providers

import com.nhaarman.mockitokotlin2.mock
import io.reactivex.rxjava3.core.Scheduler
import org.junit.Before
import org.junit.Test

class AppSchedulerProviderTest {

    private lateinit var appSchedulerProvider: AppSchedulerProvider
    val io: Scheduler = mock()

    @Before
    fun before() {
        appSchedulerProvider = AppSchedulerProvider(io, io)
    }

    @Test
    fun validate_create_io_item() {
        assert(appSchedulerProvider.io() != null)
    }

    @Test
    fun validate_create_ui_item() {
        assert(appSchedulerProvider.ui() != null)
    }
}