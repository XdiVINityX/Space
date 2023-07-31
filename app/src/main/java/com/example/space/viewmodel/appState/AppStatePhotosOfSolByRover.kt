package com.example.space.viewmodel.appState

import com.example.space.model.marsRoverPhotos.photos.PhotosOfSolByRoverResponseData


sealed class AppStatePhotosOfSolByRover {
    data class Success(val photosOfSolByRoverResponseData : PhotosOfSolByRoverResponseData) : AppStatePhotosOfSolByRover()
    data class Error(val throwable : Throwable) : AppStatePhotosOfSolByRover()
    object Loading : AppStatePhotosOfSolByRover()
}