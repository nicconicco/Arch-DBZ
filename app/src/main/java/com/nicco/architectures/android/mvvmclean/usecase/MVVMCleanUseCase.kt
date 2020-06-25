package com.nicco.architectures.android.mvvmclean.usecase

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvvm.MVVMModel

interface MVVMCleanUseCase {
    suspend fun findInfos() : Either<String, MVVMModel>
}