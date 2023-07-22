package com.example.space.api

import com.example.space.NASA_API_END_POINT_PICTURE_OF_THE_DAY
import com.example.space.NASA_API_KEY_NAME
import com.example.space.model.pictureOfTheDay.PictureOfTheDayResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureOfTheDayApi : BaseApiInterface {

    @GET(NASA_API_END_POINT_PICTURE_OF_THE_DAY)
    fun getPictureOfTheDay(@Query(NASA_API_KEY_NAME) apiKey : String) : Call<PictureOfTheDayResponseData>

    @GET(NASA_API_END_POINT_PICTURE_OF_THE_DAY)
    fun getPictureOfTheDayWithDate(
        @Query(NASA_API_KEY_NAME) apiKey : String,
        @Query("date") date : String
    ) : Call<PictureOfTheDayResponseData>

}