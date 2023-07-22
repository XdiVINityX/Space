package com.example.space.viewmodel.appState

import com.example.space.model.pictureOfTheDay.PictureOfTheDayResponseData

sealed class AppStatePictureOfTheDay{
    data class Success(val pictureOfTheDayResponseData : PictureOfTheDayResponseData) : AppStatePictureOfTheDay()
    data class Error(val throwable : Throwable) : AppStatePictureOfTheDay()
    object Loading : AppStatePictureOfTheDay()
}
