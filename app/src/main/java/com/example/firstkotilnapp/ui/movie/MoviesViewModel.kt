package com.example.firstkotilnapp.ui.movie

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagedList
import com.example.firstkotilnapp.data.DataManager
import com.example.firstkotilnapp.data.model.api.DataResponse
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.utils.AppConstants
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MoviesViewModel(private val dataManager: DataManager) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val moviesPagedList : LiveData<PagedList<Movie>> by lazy{
        dataManager.getApiRepository().fetchLiveMoviePagedList(compositeDisposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
