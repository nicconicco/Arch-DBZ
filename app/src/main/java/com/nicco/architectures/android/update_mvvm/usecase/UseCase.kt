package com.nicco.architectures.android.update_mvvm.usecase

import com.arch.core.base.Either

interface UseCase {
    suspend fun getMvvmUpdate() : Either<String, String>
}