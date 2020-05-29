package com.nicco.architectures.android.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.isA
import com.nhaarman.mockitokotlin2.verify
import com.nicco.architectures.android.base.Resource
import com.nicco.architectures.android.mvvm.State.Loading
import com.nicco.architectures.android.network.NetworkFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MVVMViewModelV2Test {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper: NetworkFake


    @Mock
    private lateinit var apiUsersObserver: Observer<Resource<MVVMModel>>

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            val response = MVVMModel(url = "ok")
            doReturn(response)
                .`when`(apiHelper)
                .createMVVMInfos()

            val viewModel = MVVMViewModelV2(apiHelper)

            viewModel.getUsers().observeForever(apiUsersObserver)

            verify(apiHelper).createMVVMInfos()

            verify(apiUsersObserver).onChanged(Resource.success(response))

            viewModel.getUsers().removeObserver(apiUsersObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(apiHelper)
                .createMVVMInfos()
            val viewModel = MVVMViewModelV2(apiHelper)
            viewModel.getUsers().observeForever(apiUsersObserver)
            verify(apiHelper).createMVVMInfos()
            verify(apiUsersObserver).onChanged(
                Resource.error(
                    RuntimeException(errorMessage).toString(),
                    null
                )
            )
            viewModel.getUsers().removeObserver(apiUsersObserver)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }
}