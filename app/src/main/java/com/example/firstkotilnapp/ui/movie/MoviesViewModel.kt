package com.example.firstkotilnapp.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
    private val movies = MutableLiveData<PagedList<Movie>>()

    val moviesList: LiveData<PagedList<Movie>>
        get() = movies

    init {
        movies.value = dataManager.getApiRepository().fetchLiveMoviePagedList(compositeDisposable).value
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
