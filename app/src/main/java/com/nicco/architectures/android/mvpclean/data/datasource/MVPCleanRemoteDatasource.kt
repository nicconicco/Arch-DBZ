package com.nicco.architectures.android.mvpclean.data.datasource

import com.nicco.architectures.android.base.network.NetworkFake
import com.nicco.architectures.android.mvp.MVPModel
import javax.inject.Inject

class MVPCleanRemoteDatasource @Inject constructor(
    private val networkFake: NetworkFake
):
    MVPCleanDatasource {
    override fun getData() : MVPModel {
        return networkFake.createMVPClean()
    }
}