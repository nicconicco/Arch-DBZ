package com.nicco.architectures.android.mvvmclean.di

import com.arch.core.base.database.DatabaseFake
import com.arch.core.base.network.NetworkFake
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanDatasource
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanLocalDatasource
import com.nicco.architectures.android.mvvmclean.data.datasource.MVVMCleanRemoteDatasource
import com.nicco.architectures.android.mvvmclean.data.repository.MVVMCleanRepository
import com.nicco.architectures.android.mvvmclean.data.repository.MVVMCleanRepositoryImp
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