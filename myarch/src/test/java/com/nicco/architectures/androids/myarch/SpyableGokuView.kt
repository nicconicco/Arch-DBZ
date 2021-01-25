package com.nicco.architectures.androids.myarch

import com.nicco.architectures.androids.myarch.ui_contract.ArchGokuView

open class SpyableGokuView : ArchGokuView {
    override fun showProgress(show: Boolean) {
    }

    override fun showError(error: String?) {
    }

    override fun showGoku(greeting: String?) {
    }
}