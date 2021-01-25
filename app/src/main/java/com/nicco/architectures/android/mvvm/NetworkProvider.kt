package com.nicco.architectures.android.mvvm

import com.arch.core.base.Either
import com.arch.core.domain.MVVMModel

interface NetworkProvider {
    suspend fun findInfos() : Either<String, MVVMModel>
}

open class NetworkProviderImp: NetworkProvider {
    override suspend fun findInfos(): Either<String, MVVMModel> {
        return try {
            Either.Right(MVVMModel(url = "ok"))
        } catch (e: Exception) {
            Either.Left("nok")
        }
    }
}