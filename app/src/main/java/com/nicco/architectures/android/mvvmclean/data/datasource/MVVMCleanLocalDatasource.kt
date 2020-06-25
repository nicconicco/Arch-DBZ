package com.nicco.architectures.android.mvvmclean.data.datasource

import com.nicco.architectures.android.base.database.DatabaseFake
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvvm.MVVMModel
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanDatasource
import javax.inject.Inject

class MVVMCleanLocalDatasource @Inject constructor(
    val databaseFake: DatabaseFake
) :
    MVVMCleanDatasource {
    override fun getData() : MVVMModel {
        return databaseFake.createMVVMModel()
    }
}