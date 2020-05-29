package com.nicco.architectures.android.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nicco.architectures.android.base.Either
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MVVMViewModelV4Test {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    lateinit var mvvmViewModelV4: MVVMViewModelV4

    val networkUseCaseImp : NetworkUseCase = mock()

    @Mock
    lateinit var observer: Observer<ViewState>

    @Before
    fun before(){
        MockitoAnnotations.initMocks(this)
        mvvmViewModelV4 = MVVMViewModelV4(networkUseCaseImp)
        mvvmViewModelV4.viewState.observeForever(observer)
    }

    @Test
    fun `Test example`() =
        runBlockingTest {
            val expectedStateSuccess = ViewState.showInfosMVVm::class.java
            val response = MVVMModel(url = "fake")
            val result: Either<String, MVVMModel>? = Either.Right(response)

           `when`(networkUseCaseImp.execute()).thenReturn(result)

            // When
            mvvmViewModelV4.findInfosMVVM()

            // Then
            assert(mvvmViewModelV4.viewState.value != null)
            verify(observer).onChanged(ViewState.loading(true))
            verify(observer).onChanged(ViewState.showInfosMVVm(response))
            verify(observer).onChanged(ViewState.loading(false))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }
}