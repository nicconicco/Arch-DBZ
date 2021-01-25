package com.nicco.architectures.android.mvpclean.data.datasource

import com.arch.core.base.network.NetworkFake
import com.arch.core.domain.MVPModel

class MVPCleanRemoteDatasource(
    private val networkFake: NetworkFake
) :
    MVPCleanDatasource {
    override fun getData(): MVPModel {
        return networkFake.createMVPClean()
    }
}