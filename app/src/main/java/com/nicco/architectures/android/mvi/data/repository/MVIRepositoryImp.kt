package com.nicco.architectures.android.mvi.data.repository

import com.nicco.architectures.android.mvi.data.datasource.MVIDatasource
import com.nicco.architectures.android.mvi.data.MVIModel

class MVIRepositoryImp(
    private val localDatasource: MVIDatasource,
    private val remoteDatasource: MVIDatasource
) : MVIRepository {
    override fun loadMVIModel(): MVIModel {
        val cache = localDatasource.getData()

        return if(cache.url.isNotEmpty()) {
            cache
        } else {
            val network = remoteDatasource.getData()
            cache.url = network.url
            cache
        }
    }
}