package com.example.firstkotilnapp.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.data.remote.network.ApiClient
import com.example.firstkotilnapp.data.remote.network.ApiService
import com.example.firstkotilnapp.ui.movie.MovieDataSourceFactory
import com.example.firstkotilnapp.utils.AppConstants
import io.reactivex.disposables.CompositeDisposable


class ApiRepository {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList (compositeDisposable: CompositeDisposable) : LiveData<PagedList<Movie>> {

        val apiService: ApiService = ApiClient.getApiClient()!!
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(AppConstants.PAGE_SIZE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        Log.i("Here" , "REPO")

        return moviePagedList
    }


}