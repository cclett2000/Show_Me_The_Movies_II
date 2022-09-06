package com.example.showmethemoviesii_returnoftheflixster.rView

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.showmethemoviesii_returnoftheflixster.MovieDetailActivity
import com.example.showmethemoviesii_returnoftheflixster.R
import com.example.showmethemoviesii_returnoftheflixster.model.view_model.Movie
import com.example.showmethemoviesii_returnoftheflixster.model.view_model.Person

class MovieAdapter (private val itemList: MutableList<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    // icky formatting for movie info
    private var user_score_format = "User Score: \t\t\t\t\t\t\t\t\t\t\t\t  "
    private var date_format = "Release Date: \t\t\t\t\t\t"

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_movie_design, parent, false)
            return ViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val model = itemList[position]
            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context, MovieDetailActivity::class.java)
                intent.putExtra("name", model.name)
                intent.putExtra("overview", model.overview)
                intent.putExtra("img_path", model.img_path)
                holder.itemView.context.startActivity(intent)
            }
            holder.movieName.text = model.name
            holder.releaseDate.text = date_format + model.release_date
            holder.userScore.text = user_score_format + (model.user_score?.times(10))?.toInt().toString() + "%"
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w500/" + model.img_path)
                .placeholder(R.drawable.cropped_placeholder)
                .fitCenter()
                .into(holder.movieImage)

        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
            val movieImage: ImageView = ItemView.findViewById(R.id.movie_image)
            val movieName: TextView = ItemView.findViewById(R.id.movie_name)
            val releaseDate: TextView = ItemView.findViewById(R.id.movie_release_date)
            val userScore: TextView = ItemView.findViewById(R.id.movie_score)
        }
}
