package com.nicco.architectures.androids.myarch

import com.nicco.architectures.androids.myarch.ui_contract.ViewStatus
import com.nicco.architectures.androids.myarch.ui_contract.ArchState
import io.mockk.spyk
import org.junit.Test
import java.net.SocketException

//@RunWith(MockitoJUnitRunner::class)
class ArchGokuViewTests {

    // with mockito
//    @Spy
//    private lateinit var view: SpyableGreetingView

    val view = spyk<SpyableGokuView>()


    @Test
    fun `gokuImgs fetch in progress and user sees progress bar`() {
        val view = spyk(SpyableGokuView())
        // Setup
        val loadingState = ArchState(
            fetchStatus = ViewStatus.Loading,
            gokuImg = null,
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
    fun `gokuImgs fetch failed with an error`() {
        // Setup
        val errorMsg = SocketException().message
        val errorState =
            ArchState(fetchStatus = ViewStatus.Failure, gokuImg = null, error = errorMsg)
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
    fun `gokuImgs fetch success with an greeting`() {
        // Setup
        val successState =
            ArchState(fetchStatus = ViewStatus.Success, gokuImg = "Wooohooo!", error = null)
        // Act
        view.render(successState)
        // Assert

        // with mockito
//        verify(view).showProgress(false)
//        verify(view).showError(errorMsg)
        io.mockk.verify {
            view.showProgress(false)
            view.showGoku("Wooohooo!")
        }
    }
}