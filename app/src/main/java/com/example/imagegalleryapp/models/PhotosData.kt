package com.example.imagegalleryapp.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotosData(
    @Json(name = "photos")
    val photos: Photos?,
    @Json(name = "stat")
    val stat: String?
)