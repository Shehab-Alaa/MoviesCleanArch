package com.example.firstkotilnapp.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.firstkotilnapp.data.model.db.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>()
{

    private val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(compositeDisposable)
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }


}