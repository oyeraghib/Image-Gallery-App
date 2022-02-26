package com.example.imagegalleryapp.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.imagegalleryapp.models.Photo
import com.example.imagegalleryapp.repository.HomePagingSource
import com.example.imagegalleryapp.repository.PhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//@HiltViewModel
//class HomeViewModel @Inject constructor(
//    private val photosRepository: PhotosRepository
//): ViewModel() {
//
//    val currentQuery = MutableLiveData<Photo>()
//
//
//    val photos = currentQuery.switchMap {
//        photosRepository.getImageResults(it)
//    }
//
//        fun getAllPhotos() {
//
//        }

//}