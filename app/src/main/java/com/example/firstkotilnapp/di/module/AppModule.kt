package com.example.firstkotilnapp.di.module

import com.example.firstkotilnapp.data.remote.network.ApiService
import com.example.firstkotilnapp.utils.AppConstants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single { get<Retrofit>().create(ApiService::class.java) }
    single { provideRetrofit() }

}

private fun provideRetrofit() = Retrofit.Builder()
    .baseUrl(AppConstants.BASE_URL)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .build()