package com.example.imagegalleryapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.Photo
import com.example.imagegalleryapp.data.PhotosRepository
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