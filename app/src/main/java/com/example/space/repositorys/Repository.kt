package com.example.space.repositorys

import com.example.space.api.PictureOfTheDayApi

interface Repository {
    fun getPictureOfTheDayApi(): PictureOfTheDayApi
}