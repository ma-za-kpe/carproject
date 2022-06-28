package com.ryggs.cars

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Cars: Application() {

    // initiate analytics, crashlytics, etc
    override fun onCreate() {
        super.onCreate()
        Timber.plant()
    }

}