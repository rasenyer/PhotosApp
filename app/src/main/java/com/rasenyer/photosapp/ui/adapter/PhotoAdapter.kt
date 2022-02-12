package com.rasenyer.photosapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rasenyer.photosapp.R
import com.rasenyer.photosapp.data.remote.model.Photo
import com.rasenyer.photosapp.databinding.ItemPhotoBinding
import com.rasenyer.photosapp.ui.fragments.HomeFragmentDirections

class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {

    private var photoList = emptyList<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {

        val photo = photoList[position]

        myViewHolder.binding.mImageView.load(photo.url){
            placeholder(R.drawable.ic_image)
            error(R.drawable.ic_image)
            crossfade(true)
            crossfade(400)
        }
        myViewHolder.binding.mTextViewAlbumId.text = photo.albumId.toString()
        myViewHolder.binding.mTextViewPhotoId.text = photo.photoId.toString()
        myViewHolder.binding.mTextViewTitle.text = photo.title

        myViewHolder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(photo)
            it.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int { return photoList.size }

    inner class MyViewHolder(val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newPhotoList: List<Photo>) {

        photoList = newPhotoList
        notifyDataSetChanged()

    }

}