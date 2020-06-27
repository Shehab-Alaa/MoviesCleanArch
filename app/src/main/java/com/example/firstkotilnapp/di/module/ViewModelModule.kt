package com.example.firstkotilnapp.di.module

import com.example.firstkotilnapp.data.DataManager
import com.example.firstkotilnapp.ui.ViewModelsFactory
import org.koin.dsl.module

val viewModelModule = module{
    single { provideDataManager()}
    single { ViewModelsFactory(get()) }
}

private fun provideDataManager() = DataManager()