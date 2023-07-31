package com.example.space.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.BuildConfig
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.repositorys.repositoryRovers.RepositoryRoverImp
import com.example.space.viewmodel.appState.AppStateManifestOfRover
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsSolOfRoverViewModel(
    private val liveDataToObserve: MutableLiveData<AppStateManifestOfRover> = MutableLiveData(),
    private val repositoryImp: RepositoryRoverImp = RepositoryRoverImp()
) : ViewModel() {


    fun getLiveData() : MutableLiveData<AppStateManifestOfRover>{
        return liveDataToObserve
    }

    fun sendRequestManifestRoverPerseverance(){
        repositoryImp.getRoversApi().getManifestRoverPerseverance(BuildConfig.NASA_API_KEY).enqueue(callback)
    }

    private val callback = object : Callback<ManifestRoverResponseData>{
        override fun onResponse(call: Call<ManifestRoverResponseData>, response: Response<ManifestRoverResponseData>) {
           if(response.isSuccessful && response.body() != null){
               liveDataToObserve.postValue(AppStateManifestOfRover.Success(response.body()!!))
           }
           else{
               liveDataToObserve.postValue(AppStateManifestOfRover.Error(throw IllegalStateException("Пришел неверный ответ")))
           }
        }

        override fun onFailure(call: Call<ManifestRoverResponseData>, t: Throwable) {
            TODO("Not yet implemented")
        }

    }



}