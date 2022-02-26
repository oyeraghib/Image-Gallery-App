package com.example.imagegalleryapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.imagegalleryapp.api.PhotosApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosRepository @Inject constructor(val photosApi: PhotosApi) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { SearchPagingSource(photosApi, query) }
        ).liveData


    fun getImageResults() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { HomePagingSource(photosApi)}
        ).liveData
}