package com.nicco.architectures.android.mvvmclean.data.datasource

import com.arch.core.domain.MVVMModel

interface MVVMCleanDatasource {
    fun getData() : MVVMModel
}