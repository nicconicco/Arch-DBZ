package com.arch.core.base.database

import com.arch.core.domain.MVPModel
import com.arch.core.domain.MVVMModel


class DatabaseFake {
    fun createMVVMModel(): MVVMModel = MVVMModel(url = "")

    val cacheDatabaseFake = MVPModel(url = "")
}