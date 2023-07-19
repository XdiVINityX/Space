package com.example.space.repositorys.pictureOfTheDay

import com.example.space.api.PictureOfTheDayApi
import com.example.space.api.RoversApi

interface RepositoryPictureOfTheDay {
    fun getPictureOfTheDayApi(): PictureOfTheDayApi
}