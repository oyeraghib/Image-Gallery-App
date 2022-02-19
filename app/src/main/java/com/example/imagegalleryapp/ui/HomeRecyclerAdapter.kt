package com.example.imagegalleryapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api.models.Photo
import com.example.imagegalleryapp.databinding.ListItemPhotosBinding

class HomeRecyclerAdapter() :
    ListAdapter<Photo, HomeRecyclerAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    class PhotoViewHolder(val binding: ListItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root)

    class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem === newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemPhotosBinding.inflate(inflater, parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        Glide.with(holder.itemView.context)
            .load(photo.urlS)
            .centerCrop()
            .into(holder.binding.ivPhoto)

    }
}