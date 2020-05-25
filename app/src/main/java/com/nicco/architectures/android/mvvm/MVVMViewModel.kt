package com.nicco.architectures.android.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nicco.architectures.android.base.BaseViewModel
import com.nicco.architectures.android.network.NetworkFake

class MVVMViewModel : BaseViewModel() {

    private val _actionView = MutableLiveData<MVVMModel>()
    val actionView: LiveData<MVVMModel>
        get() = _actionView

    lateinit var networkFake: NetworkFake
}