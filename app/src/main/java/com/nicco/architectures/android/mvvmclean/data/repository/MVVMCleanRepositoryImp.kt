package com.nicco.architectures.android.mvvmclean.data.repository

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvvm.MVVMModel
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanDatasource
import javax.inject.Inject

class MVVMCleanRepositoryImp @Inject constructor(
    private val mvpCleanLocalDatasource: MVVMCleanDatasource,
    private val mvpCleanRemoteDatasource: MVVMCleanDatasource
) : MVVMCleanRepository {
    override fun findInfos(): Either<String, MVVMModel> {
        val cache = mvpCleanLocalDatasource.getData()

        return if (cache.url.isNotEmpty()) {
            Either.Right(cache)
        } else {
            val networkObject = mvpCleanRemoteDatasource.getData()

            cache.url = networkObject.url
            Either.Right(networkObject)
        }
    }
}