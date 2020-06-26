package com.example.firstkotilnapp.data.model.api

import com.example.firstkotilnapp.data.model.db.Movie
import com.google.gson.annotations.SerializedName

data class DataResponse(
    val page: Int,
    @SerializedName("results")
    val movieList: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)