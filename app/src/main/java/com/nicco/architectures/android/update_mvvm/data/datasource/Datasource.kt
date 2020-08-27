package com.nicco.architectures.android.update_mvvm.data.datasource

import com.nicco.architectures.android.base.Either

interface Datasource {
    suspend fun getLink(): Either<String, String>
}