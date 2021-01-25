package com.nicco.architectures.android.mvpclean.data.datasource

import com.arch.core.base.database.DatabaseFake
import com.arch.core.domain.MVPModel

class MVPCleanLocalDatasource (
    val databaseFake: DatabaseFake
) :
    MVPCleanDatasource {
    override fun getData() : MVPModel {
        return databaseFake.cacheDatabaseFake
    }
}