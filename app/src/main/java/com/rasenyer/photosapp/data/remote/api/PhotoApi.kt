package com.rasenyer.photosapp.data.remote.api

import com.rasenyer.photosapp.data.remote.model.Photo
import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {

    @GET("/photos")
    suspend fun getPhotoList(): Response<List<Photo>>

}