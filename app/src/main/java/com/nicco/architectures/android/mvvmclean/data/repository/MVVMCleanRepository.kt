package com.nicco.architectures.android.mvvmclean.data.repository

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvvm.MVVMModel

interface MVVMCleanRepository {
    fun findInfos(): Either<String, MVVMModel>
}