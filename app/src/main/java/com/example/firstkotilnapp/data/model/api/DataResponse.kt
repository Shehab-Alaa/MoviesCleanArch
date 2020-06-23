package com.example.firstkotilnapp.data.model.api

import com.example.firstkotilnapp.data.model.db.Movie
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataResponse : Serializable {

    @SerializedName("results")
    var movies: List<Movie>? = null

    @SerializedName("page")
    var page: Int? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

}