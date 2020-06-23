package com.nicco.architectures.android.base

import androidx.lifecycle.AndroidViewModel
import com.nicco.architectures.android.MyApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class BaseCoroutineScope : CoroutineScope, AndroidViewModel(MyApp()) {

    val job = SupervisorJob()
    val uiScope = CoroutineScope(Main + job)
    val ioScope = CoroutineScope(IO + job)

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}