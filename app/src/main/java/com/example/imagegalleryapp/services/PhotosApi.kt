package com.example.imagegalleryapp.services

import com.example.imagegalleryapp.Constants
import com.example.imagegalleryapp.models.PhotosData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApi {

    @GET("rest/")
    suspend fun getImages(
        @Query("method") method: String = "flickr.photos.getRecent",
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "${Constants.API_KEY}",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1,
        @Query("extras") extras: String = "url_s"
        ): Response<PhotosData>

}





