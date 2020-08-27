package com.nicco.architectures.android.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nicco.architectures.android.base.Either
import io.mockk.coEvery
import io.mockk.coVerifyOrder
import io.mockk.mockk
import io.mockk.verifyOrder
import kotlinx.coroutines.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MVVMViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    lateinit var mvvmViewModelV4: MVVMViewModel

    val networkUseCaseImp: NetworkProvider = mockk()

    val scope = Dispatchers.Unconfined

    var observer: Observer<ViewState> = mockk(relaxed = true)

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        mvvmViewModelV4 = MVVMViewModel(networkUseCaseImp, scope, scope)
        mvvmViewModelV4.viewState.observeForever(observer)
    }

    @Test
    fun `Test example`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example1`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example2`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example3`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example4`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example5`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example6`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example7`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example8`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example9`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example10`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example11`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example12`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example13`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example14`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example15`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example16`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example17`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example18`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example19`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example20`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }

    @Test
    fun `Test example22`() {
        val expectedStateSuccess = ViewState.showInfosMVVm::class.java
        val response = MVVMModel(url = "fake")
        val result: Either<String, MVVMModel> = Either.Right(response)

        runBlocking {
            coEvery {
                networkUseCaseImp.findInfos()
            } returns result
        }

        // When
        mvvmViewModelV4.findInfosMVVM()

        // Then
        coVerifyOrder {
            assert(mvvmViewModelV4.viewState.value != null)
            (observer).onChanged(ViewState.loading(true))
            (observer).onChanged(ViewState.loading(false))
            (observer).onChanged(ViewState.showInfosMVVm(response))
            assertThat(mvvmViewModelV4.viewState.value, IsInstanceOf(expectedStateSuccess))
            assert(mvvmViewModelV4.viewState.value == ViewState.showInfosMVVm(response))
        }

        mvvmViewModelV4.viewState.removeObserver(observer)
    }
}