package com.example.imagegalleryapp.data

import com.example.api.PhotosDataClient
import com.example.api.models.Photo

class PhotosRepository {

    val api = PhotosDataClient.api

    suspend fun getPhotos(): List<Photo>? {
        val response = api.getImages()
        return response.body()?.photos?.photo!!
    }
}