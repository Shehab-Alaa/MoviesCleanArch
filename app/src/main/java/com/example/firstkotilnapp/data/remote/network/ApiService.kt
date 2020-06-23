package com.example.firstkotilnapp.data.remote.network

import com.example.firstkotilnapp.data.model.api.DataResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("/3/movie/{category}")
    fun getMovies(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Single<DataResponse?>?

}