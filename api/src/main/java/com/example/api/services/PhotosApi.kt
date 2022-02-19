package com.example.api.services

import com.example.api.models.Photo
import com.example.api.models.Photos
import com.example.api.models.PhotosData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {

    @GET("rest/")
    suspend fun getImages(
    ): Response<PhotosData>
//
//    @GET("rest/")
//    suspend fun getImagesList(
//    ): Response<Photos>
}





