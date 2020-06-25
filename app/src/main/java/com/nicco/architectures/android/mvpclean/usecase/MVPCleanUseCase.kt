package com.nicco.architectures.android.mvpclean.usecase

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvp.MVPModel

interface MVPCleanUseCase {
    suspend fun findInfos() : Either<String, MVPModel>
}