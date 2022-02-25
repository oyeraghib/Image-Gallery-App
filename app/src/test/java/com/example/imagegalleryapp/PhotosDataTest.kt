package com.example.imagegalleryapp

import com.example.imagegalleryapp.Constants.api
import com.example.imagegalleryapp.di.AppModule
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull

import org.junit.Test
import retrofit2.Retrofit

class PhotosDataTest {


    @Test
    fun `get PhotosData`() {
        runBlocking {
            val req = resp.getImages()
            assertNotNull(req.body()?.photos)
        }

    }
}