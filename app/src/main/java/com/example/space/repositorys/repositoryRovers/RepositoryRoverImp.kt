package com.example.space.repositorys.repositoryRovers

import com.example.space.Retrofit.RetrofitClient
import com.example.space.api.RoversApi


class RepositoryRoverImp() : RepositoryRover {

    override fun getRoversApi(): RoversApi {
       return RetrofitClient.createService(RoversApi::class.java)
    }
}
