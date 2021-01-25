package com.nicco.architectures.android.update_mvvm.data.datasource

import com.arch.core.base.Either

interface Datasource {
    suspend fun getLink(): Either<String, String>
}