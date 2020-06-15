package com.nicco.architectures.android.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nicco.architectures.android.base.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MVVMViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    lateinit var mvvmViewModelV4: MVVMViewModel

    val networkUseCaseImp : NetworkProvider = mock()

    @Mock
    lateinit var observer: Observer<ViewState>

    @Before
    fun before(){
        MockitoAnnotations.initMocks(this)
        mvvmViewModelV4 = MVVMViewModel(networkUseCaseImp)
        mvvmViewModelV4.viewState.observeForever(observer)
    }

    @Test
    fun `Test example`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example1`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example2`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example3`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example5`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example6`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example7`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example8`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example9`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example10`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }

    @Test
    fun `Test example11`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example12`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example13`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example14`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example15`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example16`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example17`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example18`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
    @Test
    fun `Test example19`() {
        GlobalScope.launch {
            withContext(Dispatchers.Unconfined) {
                val expectedStateSuccess = ViewState.showInfosMVVm::class.java
                val response = MVVMModel(url = "fake")
                val result: Either<String, MVVMModel>? = Either.Right(response)

                `when`(networkUseCaseImp.findInfos()).thenReturn(result)

                // When
                mvvmViewModelV4.findInfosMVVM()

                // Then
                assert(mvvmViewModelV4.viewState.value != null)
                verify(observer).onChanged(ViewState.loading(true))
                verify(observer).onChanged(ViewState.showInfosMVVm(response))
                verify(observer).onChanged(ViewState.loading(false))
                assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
                assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))

                mvvmViewModelV4.viewState.removeObserver(observer)
            }
        }
    }
}