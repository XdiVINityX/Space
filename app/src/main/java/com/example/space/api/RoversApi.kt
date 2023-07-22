package com.example.space.api

import com.example.space.NASA_API_END_POINT_MANIFEST_ROVER_PERSEVERANCE
import com.example.space.NASA_API_END_POINT_ROVER_PERSEVERANCE
import com.example.space.NASA_API_KEY_NAME
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.model.marsRoverPhotos.Rovers.RoverResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RoversApi : BaseApiInterface {

    @GET(NASA_API_END_POINT_ROVER_PERSEVERANCE)
    fun getRoverPerseverance(@Query(NASA_API_KEY_NAME) apiKey:String ) :Call<RoverResponseData>

    @GET(NASA_API_END_POINT_MANIFEST_ROVER_PERSEVERANCE)
    fun  getManifestRoverPerseverance(@Query(NASA_API_KEY_NAME)apiKey:String ) :Call<ManifestRoverResponseData>

}