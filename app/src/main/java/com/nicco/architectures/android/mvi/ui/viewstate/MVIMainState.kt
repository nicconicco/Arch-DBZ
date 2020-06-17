package com.nicco.architectures.android.mvi.ui.viewstate

sealed class MVIMainState {
    object Idle : MVIMainState()
    data class Loading(val load: Boolean) : MVIMainState()
    data class LoadedMVI(val mviModel: MVIModel) : MVIMainState()
    data class Error(val error: String?) : MVIMainState()
}