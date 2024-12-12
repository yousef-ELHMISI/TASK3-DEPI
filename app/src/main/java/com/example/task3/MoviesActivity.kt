package com.example.task3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task3.databinding.ActivityMoviesBinding

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    private lateinit var adapter : RvAdaper

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_movies)
        // ..
        var username = intent.getStringExtra("username") ?: "yousef"
        binding.textView.text = "Welcome $username"

        //..
        val movies = listOf(
            MovieData("guess who", "This is about movie.", R.drawable.pic1)
            , MovieData("cristhmas", "This is about movie", R.drawable.pic2),
            MovieData("matrix gen", "This is about movie", R.drawable.pic3)
            , MovieData("crow", "This is about movie", R.drawable.pic4),
            MovieData("movie man", "This is about movie", R.drawable.pic5)
            , MovieData("cruise chip murder", "This is about movie", R.drawable.pic6),
            MovieData("grave diggers", "This is about movie", R.drawable.pic7)
            , MovieData("maldororo", "This is about movie", R.drawable.pic8),
        )

        adapter = RvAdaper()
        adapter.updateItems(movies)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter

    }
}