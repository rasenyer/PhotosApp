package com.rasenyer.photosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rasenyer.photosapp.repository.PhotoRepository

class PhotoViewModelFactory(private val photoRepository: PhotoRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return PhotoViewModel(photoRepository) as T

    }

}