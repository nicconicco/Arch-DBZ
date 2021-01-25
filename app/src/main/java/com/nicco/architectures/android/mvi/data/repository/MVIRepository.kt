package com.nicco.architectures.android.mvi.data.repository

import com.arch.core.domain.MVIModel

interface MVIRepository {
    fun loadMVIModel() : MVIModel
}