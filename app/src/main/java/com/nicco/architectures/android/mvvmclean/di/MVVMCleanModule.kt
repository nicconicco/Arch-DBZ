package com.nicco.architectures.android.mvvmclean.di

import com.nicco.architectures.android.base.database.DatabaseFake
import com.nicco.architectures.android.base.network.NetworkFake
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanDatasource
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanLocalDatasource
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanRemoteDatasource
import com.nicco.architectures.android.mvvmclean.data.repository.MVVMCleanRepository
import com.nicco.architectures.android.mvvmclean.data.repository.MVVMCleanRepositoryImp
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresentation
import com.nicco.architectures.android.mvpclean.presentation.MVPCleanPresentationImp
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCase
import com.nicco.architectures.android.mvpclean.usecase.MVPCleanUseCaseImp
import com.nicco.architectures.android.mvvmclean.usecase.MVVMCleanUseCase
import com.nicco.architectures.android.mvvmclean.usecase.MVVMCleanUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MVVMCleanModule {

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
    fun remoteDatasource(): MVVMCleanDatasource = MVVMCleanRemoteDatasource(provideNetworkFake())

    @Provides
    @Singleton
    fun localDatasource(): MVVMCleanDatasource = MVVMCleanLocalDatasource(provideDatabaseFake())

    @Provides
    @Singleton
    fun repository(): MVVMCleanRepository = MVVMCleanRepositoryImp(localDatasource(), remoteDatasource())

    @Provides
    @Singleton
    fun useCase(): MVVMCleanUseCase = MVVMCleanUseCaseImp(repository())
}