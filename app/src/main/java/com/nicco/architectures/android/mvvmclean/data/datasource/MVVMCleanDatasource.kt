package com.nicco.architectures.android.mvvmclean.data.datasource

import com.nicco.architectures.android.mvvm.MVVMModel

interface MVVMCleanDatasource {
    fun getData() : MVVMModel
}