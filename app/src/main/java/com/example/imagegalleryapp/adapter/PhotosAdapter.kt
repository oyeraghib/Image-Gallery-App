package com.example.imagegalleryapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagegalleryapp.databinding.ListItemPhotosBinding
import com.example.imagegalleryapp.models.Photo
import javax.inject.Inject

class PhotosAdapter
@Inject
constructor(): PagingDataAdapter<Photo, PhotosAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        Glide.with(holder.itemView.context)
            .load(photo?.urlS)
            .centerCrop()
            .into(holder.binding.ivPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemPhotosBinding.inflate(inflater, parent, false)

        return PhotoViewHolder(binding)
    }

    class PhotoViewHolder(val binding: ListItemPhotosBinding): RecyclerView.ViewHolder(binding.root){
    }

    class PhotoDiffCallback: DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id === newItem.id
        }
    }



}