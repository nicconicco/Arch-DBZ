package com.arch.core.domain

class MVPModel(
    var url: String
) {
    fun hasCache() = url.isNotBlank() || url.isNotEmpty()
}