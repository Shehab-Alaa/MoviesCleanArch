package com.example.firstkotilnapp.utils

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.ui.movie.MoviesAdapter

object BindingAdapters {

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:adapterList")
    fun setRecyclerViewData(recyclerView: RecyclerView , moviesList:List<Movie>?){
        moviesList?.let {
            (recyclerView.adapter as? MoviesAdapter)?.apply {
                addItems(moviesList)
            }
        }

    }
}