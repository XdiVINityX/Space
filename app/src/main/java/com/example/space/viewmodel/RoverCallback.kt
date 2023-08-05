package com.example.space.viewmodel

import com.example.space.model.marsRoverPhotos.Rovers.RoverResponseData

interface RoverCallback {
    fun onSuccess(response: RoverResponseData)
    fun onError(error: Throwable)
}