package com.example.moviesproject.ui.nowmovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.NowPlayingModel
import com.example.domain.model.ResultNowPlayingModel
import com.example.moviesproject.R
import com.example.moviesproject.databinding.ItemMovieBinding


class NowMovieAdapter : PagingDataAdapter<ResultNowPlayingModel, NowMovieAdapter.ResultNowPlayingViewHolder>(
    diffCallback = differ
) {

    val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

    inner class ResultNowPlayingViewHolder(val binding : ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object{
        val differ = object : DiffUtil.ItemCallback<ResultNowPlayingModel>(){
            override fun areItemsTheSame(
                oldItem: ResultNowPlayingModel,
                newItem: ResultNowPlayingModel
            ): Boolean {
                return  oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResultNowPlayingModel,
                newItem: ResultNowPlayingModel
            ): Boolean {
                return  oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: ResultNowPlayingViewHolder, position: Int) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultNowPlayingViewHolder {
        return ResultNowPlayingViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


}