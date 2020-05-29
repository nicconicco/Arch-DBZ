package com.nicco.architectures.android.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nicco.architectures.android.base.Resource
import com.nicco.architectures.android.network.NetworkFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsInstanceOf
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MVVMViewModelV3Test {


    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private var apiHelper: NetworkFake = mock()

    private var apiUsersObserver: Observer<StateV2> = mock()

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            val response = MVVMModel(url = "ok")
            val expectedStateSuccess = StateV2.Success(response)::class.java
            doReturn(response)
                .`when`(apiHelper)
                .createMVVMInfos()

            val viewModel = MVVMViewModelV3(apiHelper)

            viewModel.actionView.observeForever(apiUsersObserver)

            viewModel.fetchUsers()
            verify(apiHelper).createMVVMInfos()
            assert(viewModel.actionView.value != null)
//            verify(apiUsersObserver).onChanged(StateV2.Loading())
            assertThat(viewModel.actionView.value, IsInstanceOf(expectedStateSuccess))
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {

            val expectedStateError= StateV2.Error("ok")::class.java

            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(apiHelper)
                .createMVVMInfos()

            val viewModel = MVVMViewModelV3(apiHelper)
            viewModel.fetchUsers()
            viewModel.actionView.observeForever(apiUsersObserver)
            verify(apiHelper).createMVVMInfos()
            assertThat(viewModel.actionView.value, IsInstanceOf(expectedStateError))
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }
}