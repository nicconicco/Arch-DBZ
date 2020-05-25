package com.nicco.architectures.android.mvc

import com.nicco.architectures.android.base.BaseCorotuineScope
import com.nicco.architectures.android.network.NetworkFake

class MVCController : BaseCorotuineScope() {

    lateinit var networkFake: NetworkFake

    fun getInfos() {
        networkFake = NetworkFake()
        networkFake.createMVCInfos()
    }
}