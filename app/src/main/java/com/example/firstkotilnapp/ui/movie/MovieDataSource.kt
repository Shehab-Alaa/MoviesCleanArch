package com.example.firstkotilnapp.ui.movie

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.data.remote.network.ApiService
import com.example.firstkotilnapp.utils.AppConstants
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDataSource(private val apiService: ApiService, private val compositeDisposable: CompositeDisposable)
    : PageKeyedDataSource<Int, Movie>()
{

    private val page = AppConstants.FIRST_PAGE

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        apiService.getMovies(AppConstants.NOW_PLAYING
            , AppConstants.API_KEY
            , AppConstants.LANGUAGE , page)?.subscribeOn(Schedulers.io())
            ?.subscribe({
                it?.movies?.let { it1 -> callback.onResult(it1,null , page + 1) }
            },{
                Log.i("Here","Network Failed " + it.message)
            })?.let {
                compositeDisposable.add(
                    it
            )
            }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        apiService.getMovies(AppConstants.NOW_PLAYING
            , AppConstants.API_KEY
            , AppConstants.LANGUAGE , params.key)?.subscribeOn(Schedulers.io())
            ?.subscribe({
                if (it?.totalPages!! >= params.key ){
                   it.movies?.let { it1 -> callback.onResult(it1,params.key + 1)
                } } else {
                    Log.i("Here" , "End Of The List")
                }
            },{
                Log.i("Here","Network Failed " + it.message)
            })?.let {
                compositeDisposable.add(
                    it
                )
            }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }

}