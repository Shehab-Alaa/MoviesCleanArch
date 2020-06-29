package com.example.firstkotilnapp.ui.movie

import androidx.paging.PageKeyedDataSource
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.data.remote.network.ApiService
import com.example.firstkotilnapp.utils.AppConstants
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieDataSource()
    : PageKeyedDataSource<Int, Movie>() , KoinComponent
{

    private val apiService : ApiService by inject()
    private val page = AppConstants.FIRST_PAGE

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        /*compositeDisposable.add(
            apiService.getMovies(AppConstants.NOW_PLAYING , AppConstants.API_KEY , AppConstants.LANGUAGE ,
            page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.movieList , null , page + 1)
                },{

                })
        )*/
        GlobalScope.launch {
            val moviesList =  apiService.getMovies(AppConstants.NOW_PLAYING ,
                AppConstants.API_KEY , AppConstants.LANGUAGE ,
                page).movieList
            callback.onResult(moviesList , null , page + 1)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        GlobalScope.launch {
           val moviesList = apiService.getMovies(AppConstants.NOW_PLAYING , AppConstants.API_KEY , AppConstants.LANGUAGE ,
                params.key).movieList
           callback.onResult(moviesList , params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }

}