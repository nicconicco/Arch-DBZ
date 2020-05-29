package com.nicco.architectures.android.network

import com.google.gson.Gson
import com.nicco.architectures.android.base.BaseCoroutines
import com.nicco.architectures.android.mvvm.MVVMModel
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class CoroutineNetworkFake(
    val ioC: CoroutineContext,
    val MainC: CoroutineContext,
    val networkFake: NetworkFake
): BaseCoroutines<MVVMModel>(
    ioC,
    MainC,
    CloudErrorMapper(Gson())
) {

    override suspend fun executeOnBackground(): MVVMModel {
        return networkFake.createMVVMInfos()
    }
}