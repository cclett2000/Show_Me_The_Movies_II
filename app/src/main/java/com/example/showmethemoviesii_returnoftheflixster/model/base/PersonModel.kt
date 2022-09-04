package com.example.showmethemoviesii_returnoftheflixster.model.base

import com.example.showmethemoviesii_returnoftheflixster.model.results.PersonResults

data class PersonModel (
    val page : Int? = null,
    val results: ArrayList<PersonResults> = arrayListOf(),
    val total_page: Int? = null,
    val total_results: Int? = null
)