package com.nicco.architectures.android.mvi.data.datasource

import com.nicco.architectures.android.mvi.ui.viewstate.MVIModel

interface MVIDatasource {
    fun getData() : MVIModel
}