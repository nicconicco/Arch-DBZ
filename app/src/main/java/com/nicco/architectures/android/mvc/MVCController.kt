package com.nicco.architectures.android.mvc

import com.arch.core.base.network.NetworkFake

class MVCController {

    lateinit var networkFake: NetworkFake

    fun getInfos() {
        networkFake = NetworkFake()
        networkFake.createMVCInfos()
    }
}