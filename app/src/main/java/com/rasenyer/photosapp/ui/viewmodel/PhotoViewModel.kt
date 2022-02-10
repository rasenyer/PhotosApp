package com.rasenyer.photosapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasenyer.photosapp.data.remote.model.Photo
import com.rasenyer.photosapp.repository.PhotoRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PhotoViewModel(private val photoRepository: PhotoRepository): ViewModel() {

    val photoList: MutableLiveData<Response<List<Photo>>> = MutableLiveData()

    fun getPhotoList() {

        viewModelScope.launch {

            val getPhotoList = photoRepository.getPhotoList()
            photoList.value = getPhotoList

        }

    }

}