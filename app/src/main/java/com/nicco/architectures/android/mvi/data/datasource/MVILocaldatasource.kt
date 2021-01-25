package com.nicco.architectures.android.mvi.data.datasource

import com.arch.core.domain.MVIModel

class MVILocaldatasource : MVIDatasource {
    override fun getData(): MVIModel {
        return MVIModel("")
    }
}