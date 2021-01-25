package com.nicco.architectures.android.mvi.ui.viewstate

import com.arch.core.domain.MVIModel

sealed class MVIMainState {
    object Idle : MVIMainState()
    object Loading : MVIMainState()
    data class LoadedMVI(val mviModel: MVIModel) : MVIMainState()
    data class Error(val error: String?) : MVIMainState()
}