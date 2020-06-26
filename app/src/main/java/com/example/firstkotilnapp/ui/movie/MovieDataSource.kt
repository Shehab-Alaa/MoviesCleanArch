package com.example.firstkotilnapp.ui.movie

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.data.remote.network.ApiService
import com.example.firstkotilnapp.utils.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDataSource(private val apiService: ApiService, private val compositeDisposable: CompositeDisposable)
    : PageKeyedDataSource<Int, Movie>()
{

    private val page = AppConstants.FIRST_PAGE

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        compositeDisposable.add(
            apiService.getMovies(AppConstants.NOW_PLAYING , AppConstants.API_KEY , AppConstants.LANGUAGE ,
            page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.movieList , null , page + 1)
                },{

                })
        )

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        compositeDisposable.add(
            apiService.getMovies(AppConstants.NOW_PLAYING , AppConstants.API_KEY , AppConstants.LANGUAGE ,
                params.key).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.totalPages >= params.key){
                       callback.onResult(it.movieList , params.key + 1)
                    }else{
                        Log.i("Here" , "End of the list")
                    }
                },{
                    Log.i("Here" , "Network Failed")
                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }

}