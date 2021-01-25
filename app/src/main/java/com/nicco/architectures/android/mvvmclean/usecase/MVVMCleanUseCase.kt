package com.nicco.architectures.android.mvvmclean.usecase

import com.arch.core.base.Either
import com.arch.core.domain.MVVMModel

interface MVVMCleanUseCase {
    suspend fun findInfos() : Either<String, MVVMModel>
}