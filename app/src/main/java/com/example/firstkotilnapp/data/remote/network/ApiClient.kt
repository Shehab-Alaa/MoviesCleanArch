package com.example.firstkotilnapp.data.remote.network

import com.example.firstkotilnapp.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit : Retrofit? = null

    fun getApiClient(): ApiService? {
        if (retrofit == null){
            retrofit = buildRetrofit()
        }
        return retrofit?.create(ApiService::class.java)
    }

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}