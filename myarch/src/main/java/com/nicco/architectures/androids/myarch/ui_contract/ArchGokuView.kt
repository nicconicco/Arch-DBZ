package com.nicco.architectures.androids.myarch.ui_contract

interface ArchGokuView {
    fun render(state: ArchState) {
        when (state.fetchStatus) {
            ViewStatus.Loading -> {
                showProgress(true)
            }
            ViewStatus.Failure -> {
                showProgress(false)
                showError(state.error)
            }
            ViewStatus.Success -> {
                showProgress(false)
                showGoku(state.gokuImg)
            }
            ViewStatus.Idle -> {

            }
        }
    }

    fun showProgress(show: Boolean)
    fun showError(error: String?)
    fun showGoku(greeting: String?)
}