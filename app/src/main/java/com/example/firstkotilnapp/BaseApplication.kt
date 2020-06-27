package com.example.firstkotilnapp

import android.app.Application
import com.example.firstkotilnapp.di.module.appModule
import com.example.firstkotilnapp.di.module.viewModelModule
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule , viewModelModule))
        }
    }
}