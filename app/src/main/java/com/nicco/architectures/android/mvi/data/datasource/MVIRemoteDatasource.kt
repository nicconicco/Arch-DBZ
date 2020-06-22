package com.nicco.architectures.android.mvi.data.datasource

import com.nicco.architectures.android.mvi.ui.viewstate.MVIModel

class MVIRemoteDatasource: MVIDatasource {
    override fun getData(): MVIModel {
        return MVIModel("https://blog.mindorks.com/mvi-architecture-android-tutorial-for-beginners-step-by-step-guide")
    }
}