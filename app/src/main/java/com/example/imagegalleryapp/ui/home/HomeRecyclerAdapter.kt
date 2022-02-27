package com.example.imagegalleryapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.imagegalleryapp.R
import com.example.imagegalleryapp.models.Photo
import com.example.imagegalleryapp.databinding.ListItemPhotosBinding

class HomeRecyclerAdapter() :
    PagingDataAdapter<Photo, HomeRecyclerAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    class PhotoViewHolder(val binding: ListItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(photo: Photo){
                binding.apply {
                    Glide.with(itemView)
                        .load(photo.urlS)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(ivPhoto)
                }
            }
        }

    class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemPhotosBinding.inflate(inflater, parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)

        if(photo != null){
            holder.bind(photo)
        }
    }
}