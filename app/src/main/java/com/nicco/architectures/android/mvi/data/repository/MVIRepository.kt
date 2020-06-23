package com.nicco.architectures.android.mvi.data.repository

import com.nicco.architectures.android.mvi.data.MVIModel

interface MVIRepository {
    fun loadMVIModel() : MVIModel
}