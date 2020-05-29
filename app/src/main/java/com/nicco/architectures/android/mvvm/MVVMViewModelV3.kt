package com.nicco.architectures.android.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicco.architectures.android.base.Resource
import com.nicco.architectures.android.network.NetworkFake
import kotlinx.coroutines.launch
sealed class StateV2 {
    open class Success(val result: MVVMModel) : StateV2()
    open class Error(val msg: String) : StateV2()
    open class Loading() : StateV2()
}

class MVVMViewModelV3(
    private val apiHelper: NetworkFake
) : ViewModel() {

    private val _actionView = MutableLiveData<StateV2>()
    val actionView: LiveData<StateV2>
        get() = _actionView

    init {
    }

    fun fetchUsers() {
        viewModelScope.launch {
            _actionView.postValue(StateV2.Loading())
            try {
                val usersFromApi = apiHelper.createMVVMInfos()
                _actionView.postValue(
                    StateV2.Success(usersFromApi)
                )
            } catch (e: Exception) {
                _actionView.postValue(StateV2.Error(""))
            }
        }
    }
}