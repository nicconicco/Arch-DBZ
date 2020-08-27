package com.nicco.architectures.android.update_mvvm.data.datasource

import com.nicco.architectures.android.base.Either

class LocalDatasource : Datasource {
    override suspend fun getLink(): Either<String, String> = Either.Right("https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel")
}