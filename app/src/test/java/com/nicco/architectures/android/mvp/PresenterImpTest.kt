package com.nicco.architectures.android.mvp

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.nicco.architectures.android.mvp.providers.TestSchedulerProvider
import com.nicco.architectures.android.network.NetworkFake
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class LoginPresenterTest {

    private val mView = mock(Presenter.View::class.java)
    private val testScheduler = TestScheduler()
    private val network: NetworkFake = mock()
    private val schedulerProvider =
        TestSchedulerProvider(
            testScheduler
        )
    private val presenter =
        PresenterImp(network, schedulerProvider)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter.attach(mView)
    }

    @Test
    fun unit_test_success() {
        // Given
        val mvpModel = MVPModel(url = "https://pt.wikipedia.org/wiki/Model-view-presenter")

        val single: Single<MVPModel> = Single.create {
                emitter ->
            emitter.onSuccess(mvpModel)
        }

        // When
        whenever(network.createItem()).thenReturn(single)

        presenter.attach(mView)
        presenter.loadMvpInfos()
        verify(network).createItem()

        testScheduler.triggerActions()

        // Then
        verify(mView).showProgress(false)
        verify(mView).onLoadedInfosMvp(mvpModel)
    }

    @Test
    fun unit_test_error() {
        // Given
        val error = "Test error"
        val single: Single<MVPModel> = Single.create {
                emitter ->
            emitter.onError(Exception(error))
        }

        // When
        whenever(network.createItem()).thenReturn(single)

        presenter.attach(mView)
        presenter.loadMvpInfos()

        testScheduler.triggerActions()

        // Then
        verify(mView).showProgress(false)
    }
}