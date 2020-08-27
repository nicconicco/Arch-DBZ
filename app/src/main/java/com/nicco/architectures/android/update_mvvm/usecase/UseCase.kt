package com.nicco.architectures.android.update_mvvm.usecase

import com.nicco.architectures.android.base.Either

interface UseCase {
    suspend fun getMvvmUpdate() : Either<String, String>
}