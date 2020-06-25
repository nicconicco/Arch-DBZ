package com.nicco.architectures.android.mvvm

import androidx.lifecycle.AndroidViewModel
import com.nicco.architectures.android.MyApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class BaseViewModel :
    AndroidViewModel(MyApp()), CoroutineScope {
    val job = SupervisorJob()

    val uiScope = CoroutineScope(Dispatchers.Main + job)
    val ioScope = CoroutineScope(Dispatchers.IO + job)

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}