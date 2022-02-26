package com.example.imagegalleryapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegalleryapp.databinding.PhotosFooterBinding

class SearchPhotosLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<SearchPhotosLoadStateAdapter.LoadStateViewHolder>() {

    inner class LoadStateViewHolder(private val binding: PhotosFooterBinding) :
        RecyclerView.ViewHolder(binding.root){

        init {
            binding.btnRetry.setOnClickListener{
                retry.invoke()
            }
        }


            fun bind(loadState: LoadState){
                binding.apply {
                    progressBarSearch.isVisible = loadState is LoadState.Loading
                    btnRetry.isVisible = loadState is LoadState.Loading
                    tvError.isVisible = loadState is LoadState.Loading

                }
            }
        }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = PhotosFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return LoadStateViewHolder(binding)
    }
}