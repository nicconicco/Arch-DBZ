package com.nicco.architectures.android.mvpclean.di.modules

import com.arch.core.base.database.DatabaseFake
import com.arch.core.base.network.NetworkFake
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanDatasource
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanLocalDatasource
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanRemoteDatasource
import com.nicco.architectures.android.mvpclean.data.repository.MVPCleanRepository
import com.nicco.architectures.android.mvpclean.data.repository.MVPCleanRepositoryImp
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresenterImp
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresenter
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCase
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCaseImp
import org.koin.dsl.module

val presenterModule = module {
    factory { MVPCleanPresenterImp(
        get()
    ) as MVPCleanPresenter.Action }
}

val useCaseModule = module {
    single { MVPCleanUseCaseImp(
        get()
    ) as MVPCleanUseCase }
}

val repositoryModule = module {
    factory { MVPCleanRepositoryImp(
        MVPCleanLocalDatasource(
            DatabaseFake()
        ) as MVPCleanDatasource,
        MVPCleanRemoteDatasource(
            NetworkFake()
        ) as MVPCleanDatasource
    ) as MVPCleanRepository }
}