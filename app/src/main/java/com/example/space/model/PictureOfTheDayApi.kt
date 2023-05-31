package com.example.space.model

import com.example.space.NASA_API_END_POINT
import com.example.space.NASA_API_KEY_NAME
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureOfTheDayApi {

    @GET(NASA_API_END_POINT)
    fun getPictureOfTheDay(@Query(NASA_API_KEY_NAME) apiKey : String) : Call<PictureOfTheDayResponseData>

    @GET(NASA_API_END_POINT)
    fun getPictureOfTheDayYesterday(
        @Query(NASA_API_KEY_NAME) apiKey : String,
        @Query("date") date : String
    ) : Call<PictureOfTheDayResponseData>

}