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
    private val liveDataToObserve_Perseverance: MutableLiveData<AppStateRovers> = MutableLiveData(),
    private val liveDataToObserve_Curiosity: MutableLiveData<AppStateRovers> = MutableLiveData(),
    private val liveDataToObserve_Opportunity: MutableLiveData<AppStateRovers> = MutableLiveData(),
    private val liveDataToObserve_Spirit: MutableLiveData<AppStateRovers> = MutableLiveData(),
    private val repositoryImp: RepositoryRoverImp = RepositoryRoverImp()
) : ViewModel() {


    fun getLiveDataPerseverance() : MutableLiveData<AppStateRovers>{
        return liveDataToObserve_Perseverance
    }

    fun getLiveDataCuriosity() : MutableLiveData<AppStateRovers>{
        return liveDataToObserve_Curiosity
    }

    fun getLiveDataOpportunity() : MutableLiveData<AppStateRovers>{
        return liveDataToObserve_Opportunity
    }
    fun getLiveDataSpirit() : MutableLiveData<AppStateRovers>{
        return liveDataToObserve_Spirit
    }

    fun sendRequestRoverPerseverance(){
        repositoryImp.getRoversApi().getRoverPerseverance(BuildConfig.NASA_API_KEY).enqueue(callback(liveDataToObserve_Perseverance))
    }
    fun sendRequestRoverCuriosity(){
        repositoryImp.getRoversApi().getRoverCuriosity(BuildConfig.NASA_API_KEY).enqueue(callback(liveDataToObserve_Curiosity))
    }
    fun sendRequestRoverOpportunity(){
        repositoryImp.getRoversApi().getRoverOpportunity(BuildConfig.NASA_API_KEY).enqueue(callback(liveDataToObserve_Opportunity))
    }
    fun sendRequestRoverSpirit(){
        repositoryImp.getRoversApi().getRoverSpirit(BuildConfig.NASA_API_KEY).enqueue(callback(liveDataToObserve_Spirit))
    }

    private fun callback(liveData :MutableLiveData<AppStateRovers>) : Callback<RoverResponseData>{
        val callback  = object : Callback<RoverResponseData>{
            override fun onResponse(call: Call<RoverResponseData>, response: Response<RoverResponseData>) {
                if(response.isSuccessful && response.body() != null){
                    liveData.postValue(AppStateRovers.Success(response.body()!!))
                }
                else{
                    liveData.postValue(AppStateRovers.Error(throw IllegalStateException("Пришел неверный ответ")))
                }
            }

            override fun onFailure(call: Call<RoverResponseData>, t: Throwable) {
                //TODO("Not yet implemented")
            }

        }
        return callback

    }



}