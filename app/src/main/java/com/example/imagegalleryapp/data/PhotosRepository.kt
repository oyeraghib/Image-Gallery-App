package com.example.imagegalleryapp.data

import com.example.api.PhotosDataClient
import com.example.api.models.Photo
import com.example.api.models.Photos

class PhotosRepository {

    val api = PhotosDataClient.api

    suspend fun getPhotos(): List<Photo>? {
        val response = api.getImages()
        return response.body()?.photos?.photo!!
    }
}