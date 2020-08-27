package com.nicco.architectures.android.update_mvvm.di

import com.nicco.architectures.android.update_mvvm.data.datasource.Datasource
import com.nicco.architectures.android.update_mvvm.data.datasource.LocalDatasource
import com.nicco.architectures.android.update_mvvm.data.respository.Repository
import com.nicco.architectures.android.update_mvvm.data.respository.RepositoryImp
import com.nicco.architectures.android.update_mvvm.presentation.MvvmUpdateViewModel
import com.nicco.architectures.android.update_mvvm.usecase.UseCase
import com.nicco.architectures.android.update_mvvm.usecase.UseCaseImp
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mvvmUpdateModule = module {
    viewModel {
        MvvmUpdateViewModel(
            Dispatchers.IO,
            get()
        )
    }

    single<UseCase> {
        UseCaseImp(
            get()
        )
    }

    factory <Repository> {
        RepositoryImp(
            get()
        )
    }

    factory <Datasource>{
        LocalDatasource()
    }
}