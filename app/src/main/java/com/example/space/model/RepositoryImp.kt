package com.example.space.model

import com.example.space.NASA_API_BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RepositoryImp : Repository {


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(NASA_API_BASE_URL)
            // JSON-ответы в объекты Kotlin
            //анализатор для чтения JSON.Если JSON-ответы от сервера могут содержать неправильно сформированные элементы.
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }

    fun getPictureOfTheDayApi():PictureOfTheDayApi{
        return retrofit.create(PictureOfTheDayApi::class.java)
    }

}