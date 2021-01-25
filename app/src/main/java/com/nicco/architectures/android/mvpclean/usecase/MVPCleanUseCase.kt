package com.nicco.architectures.android.mvpclean.usecase

import com.arch.core.base.Either
import com.arch.core.domain.MVPModel

interface MVPCleanUseCase {
    suspend fun findInfos() : Either<String, MVPModel>
}