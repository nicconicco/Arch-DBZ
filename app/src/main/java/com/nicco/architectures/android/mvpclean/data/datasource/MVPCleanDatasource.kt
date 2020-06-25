package com.nicco.architectures.android.mvpclean.data.datasource

import com.nicco.architectures.android.mvp.MVPModel

interface MVPCleanDatasource {
    fun getData() : MVPModel
}