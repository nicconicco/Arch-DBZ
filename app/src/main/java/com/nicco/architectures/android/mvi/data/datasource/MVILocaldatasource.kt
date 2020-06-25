package com.nicco.architectures.android.mvi.data.datasource

import com.nicco.architectures.android.mvi.data.MVIModel

class MVILocaldatasource : MVIDatasource {
    override fun getData(): MVIModel {
        return MVIModel("")
    }
}