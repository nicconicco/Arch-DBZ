package com.nicco.architectures.android.mvpclean.data.repository

import com.arch.core.base.Either
import com.arch.core.domain.MVPModel

interface MVPCleanRepository {
    fun findInfos(): Either<String, MVPModel>
}