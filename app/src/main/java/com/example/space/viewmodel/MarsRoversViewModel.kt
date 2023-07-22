package com.example.space.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.BuildConfig
import com.example.space.model.marsRoverPhotos.Rovers.RoverResponseData
import com.example.space.repositorys.repositoryRovers.RepositoryRoverImp
import com.example.space.viewmodel.appState.AppStateRovers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRoversViewModel(
    private val liveDataToObserve: MutableLiveData<AppStateRovers> = MutableLiveData(),
    private val repositoryImp: RepositoryRoverImp = RepositoryRoverImp()
) : ViewModel() {


    fun getLiveData() : MutableLiveData<AppStateRovers>{
        return liveDataToObserve
    }

    fun sendRequestRoverPerseverance(){
        repositoryImp.getRoversApi().getRoverPerseverance(BuildConfig.NASA_API_KEY).enqueue(callback)
    }

    private val callback = object : Callback<RoverResponseData>{
        override fun onResponse(call: Call<RoverResponseData>, response: Response<RoverResponseData>) {
           if(response.isSuccessful && response.body() != null){
               liveDataToObserve.postValue(AppStateRovers.Success(response.body()!!))
           }
           else{
               liveDataToObserve.postValue(AppStateRovers.Error(throw IllegalStateException("Пришел неверный ответ")))
           }
        }

        override fun onFailure(call: Call<RoverResponseData>, t: Throwable) {
            //TODO("Not yet implemented")
        }

    }



}