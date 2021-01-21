package com.nicco.architectures.androids.myarch

import com.nicco.architectures.androids.myarch.ui_contract.GreetingView

open class SpyableGreetingView : GreetingView {
    override fun showProgress(show: Boolean) {
    }

    override fun showError(error: String?) {
    }

    override fun showGreeting(greeting: String?) {
    }
}