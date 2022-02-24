package com.example.imagegalleryapp

import com.example.imagegalleryapp.Constants.api
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull

import org.junit.Test

class PhotosDataTest {

    val resp = Constants.api

    @Test
    fun `get PhotosData`() {
        runBlocking {
            val req = resp.getImages()
            assertNotNull(req.body()?.photos)
        }

    }
}