package com.nicco.architectures.android.update_mvvm.data.respository

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.update_mvvm.data.datasource.Datasource

class RepositoryImp(
    private val localDatasource: Datasource
) :
    Repository {
    override suspend fun getMvvmUpdate(): Either<String, String> = localDatasource.getLink()
}