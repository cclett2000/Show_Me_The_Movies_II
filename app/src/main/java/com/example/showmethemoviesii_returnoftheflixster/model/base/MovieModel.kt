package com.example.showmethemoviesii_returnoftheflixster.model.base

import com.example.showmethemoviesii_returnoftheflixster.model.results.MovieResults

data class MovieModel(
    val page : Int? = null,
    val results: ArrayList<MovieResults> = arrayListOf(),
    val total_page: Int? = null,
    val total_results: Int? = null
)
