package com.example.space.viewmodel.appState

import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData

sealed class AppStateManifestOfRover{
    data class Success(val responseData : ManifestRoverResponseData) : AppStateManifestOfRover()
    data class Error(val throwable : Throwable) : AppStateManifestOfRover()
    object Loading : AppStateManifestOfRover()
}
