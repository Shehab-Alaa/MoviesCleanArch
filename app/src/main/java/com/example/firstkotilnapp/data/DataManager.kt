package com.example.firstkotilnapp.data

import com.example.firstkotilnapp.data.remote.ApiRepository

class DataManager {

    private val apiRepository = ApiRepository()

    fun getApiRepository(): ApiRepository{
        return apiRepository
    }
}