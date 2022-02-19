package com.example.api.services

import com.example.api.models.PhotosData
import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {

    @GET("rest/")
    suspend fun getImages(
    ): Response<PhotosData>

}





