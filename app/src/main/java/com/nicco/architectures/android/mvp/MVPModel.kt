package com.nicco.architectures.android.mvp

class MVPModel(
    var url: String
) {
    fun hasCache() = url.isNotBlank() || url.isNotEmpty()
}