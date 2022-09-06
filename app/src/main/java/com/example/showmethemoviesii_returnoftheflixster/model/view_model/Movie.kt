package com.example.showmethemoviesii_returnoftheflixster.model.view_model

import android.os.Parcel
import android.os.Parcelable


data class Movie (
    val name: String?,
    val img_path: String?,
    val release_date: String?,
    val user_score: Double?,

    //detail data
    val overview: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(img_path)
        parcel.writeString(release_date)
        parcel.writeValue(user_score)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}