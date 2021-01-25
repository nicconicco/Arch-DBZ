package com.nicco.architectures.android.mvvmclean.data.datasource

import com.arch.core.base.database.DatabaseFake
import com.arch.core.domain.MVVMModel
import javax.inject.Inject

class MVVMCleanLocalDatasource @Inject constructor(
    val databaseFake: DatabaseFake
) :
    MVVMCleanDatasource {
    override fun getData() : MVVMModel {
        return databaseFake.createMVVMModel()
    }
}