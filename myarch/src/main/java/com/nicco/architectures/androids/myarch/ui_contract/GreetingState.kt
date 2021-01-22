package com.nicco.architectures.androids.myarch.ui_contract

data class GreetingState(
    val fetchStatus: FetchStatus,
    val greeting: String? = null,
    val error: String? = null
)

sealed class FetchStatus {
    object Loading : FetchStatus()
    object Idle : FetchStatus()
    object Success : FetchStatus()
    object Failure : FetchStatus()
}