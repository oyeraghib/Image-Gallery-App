package com.example.imagegalleryapp

import com.example.imagegalleryapp.services.PhotosApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Constants {

    const val API_KEY = "6f102c62f41998d151e5a1b48713cf13"
    const val BASE_URL = "https://api.flickr.com/services/"


    // directly used parameters as Query in Photos.Api

//    val interceptor = Interceptor { chain ->
//        val url = chain.request()
//            .url()
//            .newBuilder()
//            .addQueryParameter("method", "flickr.photos.getRecent")
//            .addQueryParameter("per_page", "20")
//            .addQueryParameter("page", "1")
//            .addQueryParameter("api_key", API_KEY)
//            .addQueryParameter("format", "json")
//            .addQueryParameter("nojsoncallback", "1")
//            .addQueryParameter("extras", "url_s")
//            .build()
//
//        val request = chain.request()
//            .newBuilder()
//            .url(url)
//            .build()
//
//        return@Interceptor chain.proceed(request)
//    }


/*
Replaced code with dependency injection

 */
//    val okHttpClient = OkHttpClient.Builder()
////        .addInterceptor(interceptor)
//        .connectTimeout(2, TimeUnit.MINUTES)
//        .readTimeout(2, TimeUnit.MINUTES)
//        .build()
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .client(okHttpClient)
//        .addConverterFactory(MoshiConverterFactory.create())
//
//    val api = retrofit
//        .build()
//        .create(PhotosApi::class.java)
//
//
}