package com.nicco.architectures.android.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicco.architectures.android.base.Resource
import com.nicco.architectures.android.network.NetworkFake
import kotlinx.coroutines.launch

class MVVMViewModelV2(
    private val apiHelper: NetworkFake
) : ViewModel() {

    private val users = MutableLiveData<Resource<MVVMModel>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromApi = apiHelper.createMVVMInfos()
                users.postValue(Resource.success(usersFromApi))
            } catch (e: Exception) {
                users.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<MVVMModel>> {
        return users
    }
}