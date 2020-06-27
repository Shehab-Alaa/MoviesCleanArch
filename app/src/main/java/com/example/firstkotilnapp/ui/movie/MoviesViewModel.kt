package com.example.firstkotilnapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.firstkotilnapp.data.DataManager
import com.example.firstkotilnapp.data.model.db.Movie
import io.reactivex.disposables.CompositeDisposable


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
