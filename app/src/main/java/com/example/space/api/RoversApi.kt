package com.example.space.api

import com.example.space.NASA_API_END_POINT_MANIFEST_ROVER_CURIOSITY
import com.example.space.NASA_API_END_POINT_MANIFEST_ROVER_OPPORTUNITY
import com.example.space.NASA_API_END_POINT_MANIFEST_ROVER_PERSEVERANCE
import com.example.space.NASA_API_END_POINT_MANIFEST_ROVER_SPIRIT
import com.example.space.NASA_API_END_POINT_PHOTOS_ROVER_CURIOSITY
import com.example.space.NASA_API_END_POINT_PHOTOS_ROVER_OPPORTUNITY
import com.example.space.NASA_API_END_POINT_PHOTOS_ROVER_PERSEVERANCE
import com.example.space.NASA_API_END_POINT_PHOTOS_ROVER_SPIRIT
import com.example.space.NASA_API_END_POINT_ROVER_CURIOSITY
import com.example.space.NASA_API_END_POINT_ROVER_OPPORTUNITY
import com.example.space.NASA_API_END_POINT_ROVER_PERSEVERANCE
import com.example.space.NASA_API_END_POINT_ROVER_SPIRIT
import com.example.space.NASA_API_KEY_NAME
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.model.marsRoverPhotos.Rovers.RoverResponseData
import com.example.space.model.marsRoverPhotos.photos.PhotosOfSolByRoverResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RoversApi : BaseApiInterface {

    @GET(NASA_API_END_POINT_ROVER_PERSEVERANCE)
    fun getRoverPerseverance(@Query(NASA_API_KEY_NAME) apiKey: String): Call<RoverResponseData>

    @GET(NASA_API_END_POINT_ROVER_CURIOSITY)
    fun getRoverCuriosity(@Query(NASA_API_KEY_NAME) apiKey: String): Call<RoverResponseData>

    @GET(NASA_API_END_POINT_ROVER_OPPORTUNITY)
    fun getRoverOpportunity(@Query(NASA_API_KEY_NAME) apiKey: String): Call<RoverResponseData>

    @GET(NASA_API_END_POINT_ROVER_SPIRIT)
    fun getRoverSpirit(@Query(NASA_API_KEY_NAME) apiKey: String): Call<RoverResponseData>


    //manifests
    @GET(NASA_API_END_POINT_MANIFEST_ROVER_PERSEVERANCE)
    fun getManifestRoverPerseverance(@Query(NASA_API_KEY_NAME) apiKey: String): Call<ManifestRoverResponseData>

    @GET(NASA_API_END_POINT_MANIFEST_ROVER_CURIOSITY)
    fun getManifestRoverCuriosity(@Query(NASA_API_KEY_NAME) apiKey: String): Call<ManifestRoverResponseData>

    @GET(NASA_API_END_POINT_MANIFEST_ROVER_OPPORTUNITY)
    fun getManifestRoverOpportunity(@Query(NASA_API_KEY_NAME) apiKey: String): Call<ManifestRoverResponseData>

    @GET(NASA_API_END_POINT_MANIFEST_ROVER_SPIRIT)
    fun getManifestRoverSpirit(@Query(NASA_API_KEY_NAME) apiKey: String): Call<ManifestRoverResponseData>


    //photos

    @GET(NASA_API_END_POINT_PHOTOS_ROVER_PERSEVERANCE)
    fun getPhotosOfByPerseverance(
        @Query(NASA_API_KEY_NAME) apiKey: String,
        @Query("earth_date") earthDate: String
    ): Call<PhotosOfSolByRoverResponseData>

    @GET(NASA_API_END_POINT_PHOTOS_ROVER_CURIOSITY)
    fun getPhotosOfByCuriosity(
        @Query(NASA_API_KEY_NAME) apiKey: String,
        @Query("earth_date") earthDate: String
    ): Call<PhotosOfSolByRoverResponseData>

    @GET(NASA_API_END_POINT_PHOTOS_ROVER_OPPORTUNITY)
    fun getPhotosOfByOpportunity(
        @Query(NASA_API_KEY_NAME) apiKey: String,
        @Query("earth_date") earthDate: String
    ): Call<PhotosOfSolByRoverResponseData>

    @GET(NASA_API_END_POINT_PHOTOS_ROVER_SPIRIT)
    fun getPhotosOfBySpirit(
        @Query(NASA_API_KEY_NAME) apiKey: String,
        @Query("earth_date") earthDate: String
    ): Call<PhotosOfSolByRoverResponseData>

}