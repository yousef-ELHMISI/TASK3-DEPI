package com.example.task3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.databinding.ItemRvBinding

class RvAdaper : RecyclerView.Adapter<RvAdaper.MovieViewHolder>() {

    private var itemsList: List<MovieData> = emptyList()

    fun updateItems(newItems: List<MovieData>) {
        itemsList = newItems
        notifyDataSetChanged()
    }

    // ViewHolder using ViewBinding
    class MovieViewHolder(private val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieData) {
            binding.movieName.text = movie.title
            binding.movieDescription.text = movie.description
            binding.movieImage.setImageResource(movie.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size
}