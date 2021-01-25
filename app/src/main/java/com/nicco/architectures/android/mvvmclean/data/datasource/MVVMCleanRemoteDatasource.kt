package com.nicco.architectures.android.mvvmclean.data.datasource

import com.arch.core.base.network.NetworkFake
import com.arch.core.domain.MVVMModel
import javax.inject.Inject

class MVVMCleanRemoteDatasource @Inject constructor(
    private val networkFake: NetworkFake
):
    MVVMCleanDatasource {
    override fun getData() : MVVMModel {
        return networkFake.createMVVMInfos()
    }
}