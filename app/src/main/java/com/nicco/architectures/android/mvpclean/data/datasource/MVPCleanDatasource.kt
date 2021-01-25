package com.nicco.architectures.android.mvpclean.data.datasource

import com.arch.core.domain.MVPModel

interface MVPCleanDatasource {
    fun getData() : MVPModel
}