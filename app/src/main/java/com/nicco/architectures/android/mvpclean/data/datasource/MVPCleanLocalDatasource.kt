package com.nicco.architectures.android.mvpclean.data.datasource

import com.nicco.architectures.android.base.database.DatabaseFake
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanDatasource
import javax.inject.Inject

class MVPCleanLocalDatasource @Inject constructor(
    val databaseFake: DatabaseFake
) :
    MVPCleanDatasource {
    override fun getData() : MVPModel {
        return databaseFake.cacheDatabaseFake
    }
}