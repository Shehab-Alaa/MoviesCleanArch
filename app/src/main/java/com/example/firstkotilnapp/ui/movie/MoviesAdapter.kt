package com.example.firstkotilnapp.ui.movie

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotilnapp.R
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.databinding.ListItemBinding

class MoviesAdapter(val context:Context, var moviesList : List<Movie>) : PagedListAdapter<Movie,MoviesAdapter.MoviesViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context) ,
            R.layout.list_item ,
            parent ,
            false
            )
        )
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.onBind(moviesList[position])
    }

    fun addItems(movies: List<Movie>){
        movies?.let { this.moviesList = it }
        notifyDataSetChanged()
    }

    class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    inner class MoviesViewHolder(var listItemBinding: ListItemBinding) : RecyclerView.ViewHolder(listItemBinding.root){

        private lateinit var itemViewModel: ItemViewModel

        fun onBind(movie:Movie){
            itemViewModel = ItemViewModel(movie)
            listItemBinding.setVariable(com.example.firstkotilnapp.BR.itemViewModel , itemViewModel)
            listItemBinding.executePendingBindings()
        }
    }
}