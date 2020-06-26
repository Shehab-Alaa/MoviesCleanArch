package com.example.firstkotilnapp.ui.movie

import com.example.firstkotilnapp.data.model.db.Movie


class ItemViewModel(movie: Movie) {
    val moviePoster = movie.posterPath
    val movieTitle = movie.title
    val movieReleaseDate = movie.releaseDate
}