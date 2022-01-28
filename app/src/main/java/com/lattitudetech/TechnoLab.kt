package com.lattitudetech

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TechnoLab : Application() {

    override fun onCreate() {
        super.onCreate()
        edutor = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    companion object {
        private lateinit var edutor: TechnoLab

        fun context(): Context {
            return edutor.applicationContext
        }
    }
}