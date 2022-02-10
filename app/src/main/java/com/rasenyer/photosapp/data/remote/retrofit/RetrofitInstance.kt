package com.rasenyer.photosapp.data.remote.retrofit

import com.rasenyer.photosapp.data.remote.api.PhotoApi
import com.rasenyer.photosapp.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val photoApi: PhotoApi by lazy {
        retrofit.create(PhotoApi::class.java)
    }

}