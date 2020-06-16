package com.nicco.architectures.android.base.database

import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvvm.MVVMModel

class DatabaseFake {
    fun createMVVMModel(): MVVMModel = MVVMModel(url = "")

    val cacheDatabaseFake = MVPModel(url = "")
}