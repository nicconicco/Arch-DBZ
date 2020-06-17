package com.nicco.architectures.android.mvi.ui.intent

sealed class MVIIntent {
    object LoadMVIModel : MVIIntent()
}