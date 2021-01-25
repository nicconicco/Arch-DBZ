package com.nicco.architectures.android.update_mvvm.usecase

import com.arch.core.base.Either
import com.nicco.architectures.android.update_mvvm.data.respository.Repository
import java.lang.Thread.sleep

class UseCaseImp(
    private val repository: Repository
) : UseCase {
    override suspend fun getMvvmUpdate(): Either<String, String> {
        sleep(1000)
        return repository.getMvvmUpdate()
    }
}