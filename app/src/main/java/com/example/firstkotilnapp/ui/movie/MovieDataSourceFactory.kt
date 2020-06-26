package com.example.firstkotilnapp.ui.movie

import android.util.Log
import androidx.arch.core.util.Function
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.data.remote.network.ApiService
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(private val apiService: ApiService ,private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>()
{

    private val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }


}