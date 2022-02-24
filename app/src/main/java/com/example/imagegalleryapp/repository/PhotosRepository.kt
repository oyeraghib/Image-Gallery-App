package com.example.imagegalleryapp.repository

import com.example.imagegalleryapp.Constants
import com.example.imagegalleryapp.models.Photo

class PhotosRepository {

    val api = Constants.api

    suspend fun getPhotos(): List<Photo>? {
        val response = api.getImages()
        return response.body()?.photos?.photo!!
    }
}