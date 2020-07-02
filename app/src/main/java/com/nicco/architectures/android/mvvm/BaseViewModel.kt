package com.nicco.architectures.android.mvvm

import androidx.lifecycle.AndroidViewModel
import com.nicco.architectures.android.MyApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.plus
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(
    mainThread: CoroutineContext,
    inOutThread: CoroutineContext
) :
    AndroidViewModel(
        MyApp()
    ), CoroutineScope {
    val job = SupervisorJob()

    val uiScope = CoroutineScope(mainThread + job)
    val ioScope = CoroutineScope( inOutThread + job)

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}