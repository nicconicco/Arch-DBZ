package com.nicco.architectures.android.mvp

import com.arch.core.domain.MVPModel
import org.junit.Test

class MVPModelTest {

    @Test
    fun testMVPModel() {
        val mvpModel = MVPModel(url = "some infos")
        assert(mvpModel.url.isNotEmpty())
    }
}