package com.example.space.viewmodel.appState

import com.example.space.model.marsRoverPhotos.Rovers.RoverResponseData

sealed class AppStateRovers{
    data class Success(val perseveranceResponseData : RoverResponseData) : AppStateRovers()
    data class Error(val throwable : Throwable) : AppStateRovers()
    object Loading : AppStateRovers()
}
