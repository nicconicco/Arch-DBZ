package com.nicco.architectures.android.mvpclean.data.repository

import android.util.Log
import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanDatasource
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanDatasource
import com.nicco.architectures.android.mvvmclean.data.repository.MVVMCleanRepository
import javax.inject.Inject

class MVPCleanRepositoryImp(
    private val mvpCleanLocalDatasource: MVPCleanDatasource,
    private val mvpCleanRemoteDatasource: MVPCleanDatasource
) : MVPCleanRepository {
    override fun findInfos(): Either<String, MVPModel> {
        val cache = mvpCleanLocalDatasource.getData()
        Log.d("cache", "${cache.hasCache()}")

        return if (cache.hasCache()) {
            Either.Right(cache)
        } else {
            val networkObject = mvpCleanRemoteDatasource.getData()

            cache.url = networkObject.url
            Either.Right(networkObject)
        }
    }
}