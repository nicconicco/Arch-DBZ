package com.nicco.architectures.android.mvi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicco.architectures.android.mvi.data.repository.MVIRepository
import com.nicco.architectures.android.mvi.ui.intent.MVIIntent
import com.nicco.architectures.android.mvi.ui.viewstate.MVIMainState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MVIViewModel(
    private val repository: MVIRepository
) : ViewModel() {

    val userIntent = Channel<MVIIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MVIMainState>(MVIMainState.Idle)
    val state: StateFlow<MVIMainState>
        get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MVIIntent.LoadMVIModel -> loadMVIModel()
                }
            }
        }
    }

    private fun loadMVIModel() {
        viewModelScope.launch {
            _state.value = MVIMainState.Loading(true)
            _state.value = try {
                MVIMainState.LoadedMVI(repository.loadMVIModel())
            } catch (e: Exception) {
                MVIMainState.Error(e.localizedMessage)
            }
            _state.value = MVIMainState.Loading(false)
        }
    }
}