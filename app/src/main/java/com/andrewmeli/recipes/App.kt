package com.andrewmeli.recipes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application() {

    companion object {
        var appInstance: App? = null

        fun getInstance(): App = synchronized(this) {
            if (appInstance == null)
                appInstance = App()
            return appInstance!!
        }
    }
}