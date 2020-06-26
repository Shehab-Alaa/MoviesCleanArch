package com.example.firstkotilnapp.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstkotilnapp.R
import com.example.firstkotilnapp.data.DataManager
import com.example.firstkotilnapp.databinding.ActivityMoviesBinding
import com.example.firstkotilnapp.ui.ViewModelsFactory

class MoviesActivity : AppCompatActivity() {

    private lateinit var viewModelsFactory: ViewModelsFactory
    private lateinit var viewModel: MoviesViewModel
    private lateinit var activityMoviesBinding: ActivityMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelsFactory = ViewModelsFactory(DataManager())
        viewModel = ViewModelProvider(this,viewModelsFactory).get(MoviesViewModel::class.java)

        activityMoviesBinding = DataBindingUtil.setContentView(this , R.layout.activity_movies)
        activityMoviesBinding.setVariable(com.example.firstkotilnapp.BR.moviesViewModel , viewModel)

        activityMoviesBinding.lifecycleOwner = this
        activityMoviesBinding.executePendingBindings()

        activityMoviesBinding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        activityMoviesBinding.recyclerView.setHasFixedSize(true)
        activityMoviesBinding.recyclerView.adapter = MoviesAdapter(this)
    }
}