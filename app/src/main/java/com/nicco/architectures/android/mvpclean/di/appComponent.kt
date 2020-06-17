package com.nicco.architectures.android.mvpclean.di

import com.nicco.architectures.android.mvpclean.di.modules.presenterModule
import com.nicco.architectures.android.mvpclean.di.modules.repositoryModule
import com.nicco.architectures.android.mvpclean.di.modules.useCaseModule

val appComponent = listOf(
    presenterModule,
    useCaseModule,
    repositoryModule
)