package com.rasenyer.photosapp.repository

import com.rasenyer.photosapp.data.remote.model.Photo
import com.rasenyer.photosapp.data.remote.retrofit.RetrofitInstance
import retrofit2.Response

class PhotoRepository {

    suspend fun getPhotoList(): Response<List<Photo>> {
        return RetrofitInstance.photoApi.getPhotoList()
    }

}