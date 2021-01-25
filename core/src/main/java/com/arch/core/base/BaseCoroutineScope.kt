package com.arch.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class BaseCoroutineScope : CoroutineScope, ViewModel() {

    val job = SupervisorJob()
    val uiScope = CoroutineScope(Main + job)
    val ioScope = CoroutineScope(IO + job)

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}