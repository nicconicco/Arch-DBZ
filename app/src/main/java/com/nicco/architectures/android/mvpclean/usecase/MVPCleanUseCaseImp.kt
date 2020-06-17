package com.nicco.architectures.android.mvpclean.usecase

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvp.MVPModel
import com.nicco.architectures.android.mvpclean.data.repository.MVPCleanRepository

class MVPCleanUseCaseImp (
    private val mvpCleanRepository: MVPCleanRepository
) : MVPCleanUseCase {
    override suspend fun findInfos(): Either<String, MVPModel> {
        return mvpCleanRepository.findInfos()
    }
}