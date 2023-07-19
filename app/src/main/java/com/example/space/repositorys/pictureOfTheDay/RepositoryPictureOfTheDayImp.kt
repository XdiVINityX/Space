package com.example.space.repositorys.pictureOfTheDay

import com.example.space.NASA_API_BASE_URL
import com.example.space.Retrofit.RetrofitClient
import com.example.space.api.PictureOfTheDayApi
import com.example.space.api.RoversApi
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryPictureOfTheDayImp : RepositoryPictureOfTheDay {


    override fun getPictureOfTheDayApi(): PictureOfTheDayApi {
        return RetrofitClient.createService(PictureOfTheDayApi::class.java)
    }

}