package com.example.space.Retrofit

import com.example.space.NASA_API_BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(NASA_API_BASE_URL)
            // JSON-ответы в объекты Kotlin
            //анализатор для чтения JSON.Если JSON-ответы от сервера могут содержать неправильно сформированные элементы.
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }

    fun <T> createService(serviceClass : Class<T>) : T {
        return retrofit.create(serviceClass)
    }
}



