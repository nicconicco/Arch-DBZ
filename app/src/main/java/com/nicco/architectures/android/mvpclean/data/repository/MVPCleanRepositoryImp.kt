package com.nicco.architectures.android.mvpclean.data.repository

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanDatasource
import javax.inject.Inject

class MVPCleanRepositoryImp @Inject constructor(
    private val mvpCleanLocalDatasource: MVPCleanDatasource,
    private val mvpCleanRemoteDatasource: MVPCleanDatasource
) : MVPCleanRepository {
    override fun findInfos(): Either<String, MVPModel> {
        val cache = mvpCleanLocalDatasource.getData()

        return if (cache.hasCache()) {
            Either.Right(cache)
        } else {
            val networkObject = mvpCleanRemoteDatasource.getData()

            cache.url = networkObject.url
            Either.Right(networkObject)
        }
    }
}