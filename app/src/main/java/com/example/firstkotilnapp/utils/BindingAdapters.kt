package com.example.firstkotilnapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.ui.movie.MoviesAdapter

object BindingAdapters {

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:adapterList")
    fun setRecyclerViewData(recyclerView: RecyclerView , moviesList:PagedList<Movie>?){
        moviesList?.let {
            (recyclerView.adapter as? MoviesAdapter)?.apply {
                 submitList(moviesList)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:posterSrc")
    fun setMoviePosterSrc(posterImage: ImageView , posterPath : String?){
        val moviePosterURL = AppConstants.POSTER_BASE_URL + posterPath
        Glide.with(posterImage.context)
            .load(moviePosterURL)
            .into(posterImage);
    }
}