package com.example.imagegalleryapp.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.imagegalleryapp.models.Photo
import com.example.imagegalleryapp.models.PhotosData
import com.example.imagegalleryapp.services.PhotosApi
import retrofit2.HttpException
import java.io.IOException


class PhotosPagingSource constructor(private val photosApi: PhotosApi) :
    PagingSource<Int, PhotosData>() {
    override fun getRefreshKey(state: PagingState<Int, PhotosData>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotosData> {
        val page = params.key ?: 1
        return try {
            val response = photosApi.getImages()

            LoadResult.Page(
                response,
                prevKey = if (page == 1) null else (page - 1),
                nextKey = page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}


