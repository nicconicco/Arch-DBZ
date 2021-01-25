package com.nicco.architectures.android.mvi.data.datasource

import com.arch.core.domain.MVIModel

interface MVIDatasource {
    fun getData() : MVIModel
}