package com.rasenyer.photosapp.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.load
import com.rasenyer.photosapp.R
import com.rasenyer.photosapp.data.remote.model.Photo
import com.rasenyer.photosapp.databinding.FragmentDetailBinding
import com.rasenyer.photosapp.repository.PhotoRepository
import com.rasenyer.photosapp.ui.viewmodel.PhotoViewModel
import com.rasenyer.photosapp.ui.viewmodel.PhotoViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var photoViewModel: PhotoViewModel
    private val detailFragmentArgs: DetailFragmentArgs by navArgs()
    private lateinit var currentPhoto: Photo

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postRepository = PhotoRepository()
        val postViewModelFactory = PhotoViewModelFactory(postRepository)
        photoViewModel = ViewModelProvider(this, postViewModelFactory)[PhotoViewModel::class.java]

        currentPhoto = detailFragmentArgs.photo!!

        setViews()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    private fun setViews() {

        binding.mImageView.load(currentPhoto.url){
            placeholder(R.drawable.ic_image)
            error(R.drawable.ic_image)
            crossfade(true)
            crossfade(400)
        }
        binding.mTextViewTitle.text = currentPhoto.title
        binding.mTextViewAlbumId.text = resources.getString(R.string.album_id) + currentPhoto.albumId.toString()
        binding.mTextViewPhotoId.text = resources.getString(R.string.photo_id) + currentPhoto.photoId.toString()

    }

}