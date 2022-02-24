package com.example.imagegalleryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagegalleryapp.models.Photo
import com.example.imagegalleryapp.repository.PhotosRepository
import kotlinx.coroutines.launch



class HomeViewModel : ViewModel() {

    private val repo = PhotosRepository()

    private val _photos = MutableLiveData<List<Photo>>()

    val photos: LiveData<List<Photo>> = _photos

    fun fetchPhotosList() {
        viewModelScope.launch {
            _photos.postValue(repo.getPhotos())
        }
    }
}