package com.nicco.architectures.android.mvvm

import com.nicco.architectures.android.base.Either

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