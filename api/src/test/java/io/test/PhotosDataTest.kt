package io.test

import com.example.api.PhotosDataClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull

import org.junit.Test

class PhotosDataTest {

    val resp = PhotosDataClient.api

    @Test
    fun `get PhotosData`() {
        runBlocking {
            val req = resp.getImages()
            assertNotNull(req.body()?.photos)
        }

    }
}