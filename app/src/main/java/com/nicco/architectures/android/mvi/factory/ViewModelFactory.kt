package com.nicco.architectures.android.mvi.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nicco.architectures.android.mvi.data.datasource.MVIDatasource
import com.nicco.architectures.android.mvi.data.datasource.MVILocaldatasource
import com.nicco.architectures.android.mvi.data.datasource.MVIRemoteDatasource
import com.nicco.architectures.android.mvi.data.repository.MVIRepositoryImp
import com.nicco.architectures.android.mvi.ui.viewmodel.MVIViewModel

class ViewModelFactory(
    private val localDatasource: MVILocaldatasource,
    private val remoteDatasource: MVIRemoteDatasource
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(
                MVIViewModel::class.java
            )
        ) {
            return MVIViewModel(
                MVIRepositoryImp(localDatasource, remoteDatasource)
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}