package com.example.firstkotilnapp.ui.movie

import com.example.firstkotilnapp.data.model.db.Movie


class ItemViewModel(movie: Movie) {
    val movieTitle : String? = movie.title
}