package com.example.showmethemoviesii_returnoftheflixster

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.showmethemoviesii_returnoftheflixster.model.view_model.Movie

class MovieDetailActivity: AppCompatActivity() {
    // NPE caused by differing names in xml -- always double check
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        // instantiate UI elements
        val overview:TextView = findViewById(R.id.movie_overview)
        val popularity:TextView = findViewById(R.id.movie_popularity)
        val adultFlag:TextView = findViewById(R.id.movie_adult_flag)
        val image:ImageView = findViewById(R.id.movie_image)

        // get info from adapter (movie)
        val movieOverviewData = intent.getStringExtra("overview")
        val moviePopularityData = intent.getStringExtra("popularity")
        val adultFlagData = intent.getBooleanExtra("adult_flag", false)
        val movieImgPathData = intent.getStringExtra("img_path")
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/$movieImgPathData")
            .placeholder(R.drawable.cropped_placeholder)
            .fitCenter()
            .into(image)

        // set UI
        overview.text = movieOverviewData
        popularity.text = "Popularity: $moviePopularityData"
        if(adultFlagData) {
            adultFlag.text = "18+"
            adultFlag.setTextColor(Color.MAGENTA)
        }
        else {
            adultFlag.text = "PG"
            adultFlag.setTextColor(Color.CYAN)
        }

    }
}