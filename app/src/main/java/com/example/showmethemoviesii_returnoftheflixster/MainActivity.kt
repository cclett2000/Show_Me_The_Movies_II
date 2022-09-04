package com.example.showmethemoviesii_returnoftheflixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.example.showmethemoviesii_returnoftheflixster.http.RequestHandler
import com.example.showmethemoviesii_returnoftheflixster.model.results.PersonResults
import com.example.showmethemoviesii_returnoftheflixster.rView.PersonAdapter
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private val gson = Gson()
    private val client = AsyncHttpClient()
    private val params = RequestParams()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // person logic
        val personRV = findViewById<RecyclerView>(R.id.trending_people_RV)
        RequestHandler.getTrendingPeople(personRV)

        // movie logic
        val movieRV = findViewById<RecyclerView>(R.id.trending_movie_RV)
        movieRV.layoutManager = LinearLayoutManager(this)
        RequestHandler.getTrendingMovies(movieRV)
    }
}