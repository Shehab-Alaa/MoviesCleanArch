package com.example.firstkotilnapp.ui.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotilnapp.R
import com.example.firstkotilnapp.data.model.db.Movie
import com.example.firstkotilnapp.databinding.ListItemBinding

class MoviesAdapter(val context:Context) : PagedListAdapter<Movie,MoviesAdapter.MoviesViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context) ,
            R.layout.list_item ,
            parent ,
            false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    class MoviesViewHolder(var listItemBinding: ListItemBinding) : RecyclerView.ViewHolder(listItemBinding.root){

        private lateinit var itemViewModel: ItemViewModel

        fun onBind(movie:Movie){
            itemViewModel = ItemViewModel(movie)
            listItemBinding.setVariable(com.example.firstkotilnapp.BR.itemViewModel , itemViewModel)
            listItemBinding.executePendingBindings()
        }
    }
}