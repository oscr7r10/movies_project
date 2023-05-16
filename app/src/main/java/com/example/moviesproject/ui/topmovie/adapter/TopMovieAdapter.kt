package com.example.moviesproject.ui.topmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.ResultTopModel
import com.example.moviesproject.R
import com.example.moviesproject.databinding.ItemMovieBinding

class TopMovieAdapter : PagingDataAdapter<ResultTopModel, TopMovieAdapter.ResultTopModelViewHolder>(
    differCallback
) {

    val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

    inner class ResultTopModelViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object{
        val differCallback = object : DiffUtil.ItemCallback<ResultTopModel>(){
            override fun areItemsTheSame(
                oldItem: ResultTopModel,
                newItem: ResultTopModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResultTopModel,
                newItem: ResultTopModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }


    override fun onBindViewHolder(holder: ResultTopModelViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            movieTitle.text = currentItem?.title ?: "Sin título"
            movieReleaseDate.text = currentItem?.release_date
        }
        Glide
            .with(holder.itemView)
            .load(POSTER_BASE_URL+currentItem?.poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.moviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultTopModelViewHolder {
        return ResultTopModelViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}