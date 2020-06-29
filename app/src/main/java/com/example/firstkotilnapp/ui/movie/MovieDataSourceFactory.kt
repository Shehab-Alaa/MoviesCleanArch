package com.example.firstkotilnapp.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.firstkotilnapp.data.model.db.Movie

class MovieDataSourceFactory()
    : DataSource.Factory<Int, Movie>()
{

    private val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource()
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }



}