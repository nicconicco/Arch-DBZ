package com.nicco.architectures.android.update_mvvm.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.update_mvvm.usecase.UseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifyOrder
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsInstanceOf
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class MvvmUpdateViewModelTest {

    private val observerFlow: FlowCollector<UpdateAction> = mockk(relaxed = true)

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private lateinit var viewModel: MvvmUpdateViewModel
    private var useCase: UseCase = mockk()
    private val scopeIO: CoroutineDispatcher = Dispatchers.Unconfined

    var observer: Observer<UpdateAction> = mockk(relaxed = true)

    @Before
    fun before() = runBlockingTest {
        viewModel = MvvmUpdateViewModel(
            scopeIO,
            useCase
        )
        viewModel.state.observeForever(observer)
    }

    @Test
    fun validate_viewmodel_flow() {
        val successState = UpdateAction.Success::class.java
        val url = "fake:OK"
        val responseOk: Either<String, String> = Either.Right(url)

        runBlockingTest {
            coEvery {
                useCase.getMvvmUpdate()
            } returns responseOk
        }

        viewModel.getMvvmUpdate()

        coVerify(exactly = 1) { useCase.getMvvmUpdate() }
        coVerify { useCase.getMvvmUpdate() }
        assert(viewModel.state.value != UpdateAction.Idle)
        (observer).onChanged(UpdateAction.ShowLoading)
        (observer).onChanged(UpdateAction.HideLoading)
        (observer).onChanged(UpdateAction.Success(url))
        assertThat(viewModel.state.value, IsInstanceOf(successState))
    }
}