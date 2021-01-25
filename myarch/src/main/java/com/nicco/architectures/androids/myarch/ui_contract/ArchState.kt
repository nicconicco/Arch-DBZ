package com.nicco.architectures.androids.myarch.ui_contract

data class ArchState(
    val fetchStatus: ViewStatus,
    val gokuImg: String? = null,
    val error: String? = null
)

sealed class ViewStatus {
    object Loading : ViewStatus()
    object Idle : ViewStatus()
    object Success : ViewStatus()
    object Failure : ViewStatus()
}