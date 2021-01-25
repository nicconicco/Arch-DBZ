package com.nicco.architectures.android.mvvmclean.data.repository

import com.arch.core.base.Either
import com.arch.core.domain.MVVMModel

interface MVVMCleanRepository {
    fun findInfos(): Either<String, MVVMModel>
}