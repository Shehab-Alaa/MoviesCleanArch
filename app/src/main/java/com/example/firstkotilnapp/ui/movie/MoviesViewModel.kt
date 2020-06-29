package com.example.firstkotilnapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.firstkotilnapp.data.DataManager
import com.example.firstkotilnapp.data.model.db.Movie


class MoviesViewModel(private val dataManager: DataManager) : ViewModel() {

    val moviesPagedList : LiveData<PagedList<Movie>> by lazy{
        dataManager.getApiRepository().fetchLiveMoviePagedList()
    }
}
