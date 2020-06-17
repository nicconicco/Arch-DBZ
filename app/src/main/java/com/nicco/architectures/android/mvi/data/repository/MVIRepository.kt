package com.nicco.architectures.android.mvi.data.repository

import com.nicco.architectures.android.mvi.ui.viewstate.MVIModel

interface MVIRepository {
    fun loadMVIModel() : MVIModel
}