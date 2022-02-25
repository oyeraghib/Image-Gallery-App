package com.example.imagegalleryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.imagegalleryapp.models.Photo
import com.example.imagegalleryapp.models.PhotosData
import com.example.imagegalleryapp.repository.PhotosPagingSource
import com.example.imagegalleryapp.services.PhotosApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
@Inject
    constructor(private val photosApi: PhotosApi): ViewModel() {

        fun getAllPhotos(): Flow<PagingData<PhotosData>> = Pager(
            config = PagingConfig(20, enablePlaceholders = false),
        ){
            PhotosPagingSource(photosApi)
        }.flow.cachedIn(viewModelScope)

}