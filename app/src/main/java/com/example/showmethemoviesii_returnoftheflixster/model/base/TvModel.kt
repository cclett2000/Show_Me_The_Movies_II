package com.example.showmethemoviesii_returnoftheflixster.model.base

import com.example.showmethemoviesii_returnoftheflixster.model.results.TvResults

// data class for the base api response
data class TvModel (
    val page : Int? = null,
    val results: ArrayList<TvResults> = arrayListOf(),
    val total_page: Int? = null,
    val total_results: Int? = null
)