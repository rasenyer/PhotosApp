package com.rasenyer.photosapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.rasenyer.photosapp.databinding.FragmentHomeBinding
import com.rasenyer.photosapp.repository.PhotoRepository
import com.rasenyer.photosapp.ui.adapter.PhotoAdapter
import com.rasenyer.photosapp.ui.viewmodel.PhotoViewModel
import com.rasenyer.photosapp.ui.viewmodel.PhotoViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var photoViewModel: PhotoViewModel
    private val postAdapter by lazy { PhotoAdapter() }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postRepository = PhotoRepository()
        val postViewModelFactory = PhotoViewModelFactory(postRepository)
        photoViewModel = ViewModelProvider(this, postViewModelFactory)[PhotoViewModel::class.java]

        photoViewModel.getPhotoList()
        photoViewModel.photoList.observe(viewLifecycleOwner) { response ->

            if (response.isSuccessful) {
                response.body()?.let { postAdapter.setData(it) }
            } else {
                Toast.makeText(context, response.code(), Toast.LENGTH_SHORT).show()
            }

        }

        setUpRecyclerView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpRecyclerView() {
        binding.mRecyclerView.adapter = postAdapter
    }

}