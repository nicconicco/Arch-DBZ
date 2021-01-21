package com.nicco.architectures.androids.myarch.ui_contract

interface GreetingView {
    fun render(state: GreetingState) {
        when (state.fetchStatus) {
            FetchStatus.Loading -> {
                showProgress(true)
            }
            FetchStatus.Failure -> {
                showProgress(false)
                showError(state.error)
            }
            FetchStatus.Success -> {
                showProgress(false)
                showGreeting(state.greeting)
            }
        }
    }

    fun showProgress(show: Boolean)
    fun showError(error: String?)
    fun showGreeting(greeting: String?)
}