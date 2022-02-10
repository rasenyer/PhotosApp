package com.rasenyer.photosapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Photo(

    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("id")
    val photoId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String

)
