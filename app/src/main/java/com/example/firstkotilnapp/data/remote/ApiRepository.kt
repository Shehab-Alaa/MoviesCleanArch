package com.example.firstkotilnapp.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.ui.movie.MovieDataSourceFactory
import com.example.firstkotilnapp.utils.AppConstants


class ApiRepository {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList () : LiveData<PagedList<Movie>> {

        //val apiService: ApiService = ApiClient.getApiClient()!!
        moviesDataSourceFactory = MovieDataSourceFactory()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(AppConstants.PAGE_SIZE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }


}