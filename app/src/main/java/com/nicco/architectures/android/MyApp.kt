package com.nicco.architectures.android

import android.app.Application
import android.util.Log.DEBUG
import com.nicco.architectures.android.BuildConfig.DEBUG
import com.nicco.architectures.android.mvpclean.di.appComponent
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.logging.Level

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appComponent)
        }
    }
}