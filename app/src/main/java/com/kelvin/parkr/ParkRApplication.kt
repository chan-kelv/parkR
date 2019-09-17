package com.kelvin.parkr

import android.app.Application
import android.content.Context
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber

class ParkRApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this

        // Timber init
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Date and time backport init
        AndroidThreeTen.init(this)
    }

    companion object {
        lateinit var appContext: Context
    }
}
