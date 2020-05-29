package com.nicco.architectures.android.mvvm

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nicco.architectures.android.base.BaseCoroutines
import com.nicco.architectures.android.network.CoroutineNetworkFake
import com.nicco.architectures.android.network.NetworkFake
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito
import org.mockito.internal.matchers.InstanceOf
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer


class MVVMViewModelTest {

    private val coroutineNetworkFake: CoroutineNetworkFake = mock()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun getActionView() = runBlockingTest {
        val observer: Observer<State<MVVMModel>> = mock()
        val io = Dispatchers.IO
        val ui = Dispatchers.Unconfined
        val networkFake = NetworkFake()

        val response =
            MVVMModel(url = "https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel")

        val expectedStateSuccess = State.Success<MVVMModel>(response)::class.java
        val expectedStateLoad = State.Loading<MVVMModel>(true)::class.java

        val resultCaptor = argumentCaptor<BaseCoroutines.Request<MVVMModel>>()
        val callback: (MVVMModel) -> Unit = mock()

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            Log.d("", it.arguments.toString())
            (it.arguments[0] as BaseCoroutines.Request<MVVMModel>).onComplete(callback)
        }.`when`(coroutineNetworkFake).execute { resultCaptor }

        val viewModel =
            MVVMViewModel(
                CoroutineNetworkFake(
                    io,
                    ui,
                    networkFake
                )
            )

        viewModel.getInfos()
        viewModel.actionView.observeForever(observer)
        assert(viewModel.actionView.value != null)
//        verify(observer).onChanged(State.Loading(true))
//        verify(observer).onChanged(State.Loading(false))
//        verify(observer).onChanged(State.Success(response))
        assertThat(viewModel.actionView.value, IsInstanceOf(expectedStateSuccess))
    }
}