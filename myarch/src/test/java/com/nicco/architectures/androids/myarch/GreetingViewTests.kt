package com.nicco.architectures.androids.myarch

import com.nicco.architectures.androids.myarch.ui_contract.FetchStatus
import com.nicco.architectures.androids.myarch.ui_contract.GreetingState
import io.mockk.spyk
import org.junit.Test
import java.net.SocketException

//@RunWith(MockitoJUnitRunner::class)
class GreetingViewTests {

    // with mockito
//    @Spy
//    private lateinit var view: SpyableGreetingView

    val view = spyk<SpyableGreetingView>()


    @Test
    fun `greeting fetch in progress and user sees progress bar`() {
        val view = spyk(SpyableGreetingView())
        // Setup
        val loadingState = GreetingState(
            fetchStatus = FetchStatus.Loading,
            greeting = null,
            error = null
        )

        // Act
        view.render(loadingState)

        // Assert
        // with mockito
//        verify(view).showProgress(true)

        //with mokk
        io.mockk.verify {
            view.showProgress(true)
        }
    }

    @Test
    fun `greeting fetch failed with an error`() {
        // Setup
        val errorMsg = SocketException().message
        val errorState =
            GreetingState(fetchStatus = FetchStatus.Failure, greeting = null, error = errorMsg)
        // Act
        view.render(errorState)
        // Assert

        // with mockito
//        verify(view).showProgress(false)
//        verify(view).showError(errorMsg)
        io.mockk.verify {
            view.showProgress(false)
            view.showError(errorMsg)
        }
    }

    @Test
    fun `greeting fetch success with an greeting`() {
        // Setup
        val successState =
            GreetingState(fetchStatus = FetchStatus.Success, greeting = "Wooohooo!", error = null)
        // Act
        view.render(successState)
        // Assert

        // with mockito
//        verify(view).showProgress(false)
//        verify(view).showError(errorMsg)
        io.mockk.verify {
            view.showProgress(false)
            view.showGreeting("Wooohooo!")
        }
    }
}