package com.nicco.architectures.android.update_mvvm.data.respository

import com.nicco.architectures.android.base.Either

interface Repository {
    suspend fun getMvvmUpdate(): Either<String, String>
}