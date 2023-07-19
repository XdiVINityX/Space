package com.example.space.api

import com.example.space.NASA_API_END_POINT_ROVER_PERSEVERANCE
import com.example.space.NASA_API_KEY_NAME
import com.example.space.model.marsRoverPhotos.Perseverance
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RoversApi {

    @GET(NASA_API_END_POINT_ROVER_PERSEVERANCE)
    fun getSolRoverPerseverance(@Query(NASA_API_KEY_NAME) apiKey:String ) :Call<Perseverance>

}