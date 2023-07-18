package com.example.space.viewmodel

import com.example.space.model.pictureOfTheDay.PictureOfTheDayResponseData

sealed class AppState{
    data class Success(val pictureOfTheDayResponseData : PictureOfTheDayResponseData) : AppState()
    data class Error(val throwable : Throwable) : AppState()
    object Loading : AppState()
}
