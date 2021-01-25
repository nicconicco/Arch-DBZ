package com.nicco.architectures.android.mvvmclean.usecase

import com.arch.core.base.Either
import com.arch.core.domain.MVVMModel
import com.nicco.architectures.android.mvvmclean.data.repository.MVVMCleanRepository
import javax.inject.Inject

class MVVMCleanUseCaseImp @Inject constructor(
    private val mvpCleanRepository: MVVMCleanRepository
) : MVVMCleanUseCase {
    override suspend fun findInfos(): Either<String, MVVMModel> {
        return mvpCleanRepository.findInfos()
    }
}