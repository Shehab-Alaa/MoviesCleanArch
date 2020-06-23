package com.example.firstkotilnapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotilnapp.data.DataManager
import com.example.firstkotilnapp.ui.movie.MoviesViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelsFactory(private val dataManager: DataManager) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(dataManager) as T
    }
}