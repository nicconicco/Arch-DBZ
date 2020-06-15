package com.nicco.architectures.android.mvpclean.di

import com.nicco.architectures.android.base.database.DatabaseFake
import com.nicco.architectures.android.base.network.NetworkFake
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanDatasource
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanLocalDatasource
import com.nicco.architectures.android.mvpclean.data.datasource.MVPCleanRemoteDatasource
import com.nicco.architectures.android.mvpclean.data.repository.MVPCleanRepository
import com.nicco.architectures.android.mvpclean.data.repository.MVPCleanRepositoryImp
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresentation
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresentationImp
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCase
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MVPCleanModule {

    @Provides
    @Singleton
    fun provideNetworkFake() =
        NetworkFake()

    @Provides
    @Singleton
    fun provideDatabaseFake() =
        DatabaseFake()

    @Provides
    @Singleton
    fun remoteDatasource(): MVPCleanDatasource = MVPCleanRemoteDatasource(provideNetworkFake())

    @Provides
    @Singleton
    fun localDatasource(): MVPCleanDatasource = MVPCleanLocalDatasource(provideDatabaseFake())

    @Provides
    @Singleton
    fun repository(): MVPCleanRepository = MVPCleanRepositoryImp(localDatasource(), remoteDatasource())

    @Provides
    @Singleton
    fun useCase(): MVPCleanUseCase = MVPCleanUseCaseImp(repository())

    @Provides
    @Singleton
    fun provideMVPCleanComponent(): MVPCleanPresentation.Action = MVPCleanPresentationImp(useCase())
}