package com.example.imagegalleryapp.services

import com.example.imagegalleryapp.models.Photo
import com.example.imagegalleryapp.models.PhotosData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApi {

    companion object {
        const val API_KEY = "6f102c62f41998d151e5a1b48713cf13"
        const val BASE_URL = "https://api.flickr.com/services/"
    }

    @GET("rest/")
    suspend fun getImages(
        @Query("method") method: String? = "flickr.photos.getRecent",
        @Query("per_page") perPage: Any? = 20,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String? = "${API_KEY}",
        @Query("format") format: String? = "json",
        @Query("nojsoncallback") nojsoncallback: Any? = 1,
        @Query("extras") extras: String? = "url_s"
    ): Response<PhotosData>


    @GET("rest/")
    suspend fun searchImage(
        @Query("method") method: String? = "flickr.photos.getRecent",
        @Query("api_key") apiKey: String? = "${API_KEY}",
        @Query("format") format: String? = "json",
        @Query("nojsoncallback") nojsoncallback: Any? = 1,
        @Query("extras") extras: String? = "url_s",
        @Query("text") text: String?
        ): Response<PhotosData>
}





