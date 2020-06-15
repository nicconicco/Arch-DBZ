package com.nicco.architectures.android.mvpclean.data.repository

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.mvp.MVPModel

interface MVPCleanRepository {
    fun findInfos(): Either<String, MVPModel>
}