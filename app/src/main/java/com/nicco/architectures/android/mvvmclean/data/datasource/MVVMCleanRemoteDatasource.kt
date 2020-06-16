package com.nicco.architectures.android.mvvmclean.data.datasource

import com.nicco.architectures.android.base.network.NetworkFake
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvvm.MVVMModel
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanDatasource
import javax.inject.Inject

class MVVMCleanRemoteDatasource @Inject constructor(
    private val networkFake: NetworkFake
):
    MVVMCleanDatasource {
    override fun getData() : MVVMModel {
        return networkFake.createMVVMInfos()
    }
}