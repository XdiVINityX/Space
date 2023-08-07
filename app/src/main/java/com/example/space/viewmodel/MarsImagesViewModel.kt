package com.example.space.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.BuildConfig
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.model.marsRoverPhotos.photos.PhotosOfSolByRoverResponseData
import com.example.space.repositorys.repositoryRovers.RepositoryRoverImp
import com.example.space.utils.enumRovers.RoversEnum
import com.example.space.viewmodel.appState.AppStateManifestOfRover
import com.example.space.viewmodel.appState.AppStatePhotosOfSolByRover
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsImagesViewModel : ViewModel() {
    private val liveDataToObserve: MutableLiveData<AppStatePhotosOfSolByRover> = MutableLiveData()
    private val repositoryImp: RepositoryRoverImp = RepositoryRoverImp()


    fun getLiveData(): MutableLiveData<AppStatePhotosOfSolByRover> {
        return liveDataToObserve
    }


    fun sendRequestImagesByRover(earthData: String,rover: RoversEnum) {
        when(rover){
            RoversEnum.PERSEVERANCE -> sendRequestImagesByPerseverance(earthData)
            RoversEnum.CURIOSITY -> sendRequestImagesByCuriosity(earthData)
            RoversEnum.OPPORTUNITY -> sendRequestImagesByOpportunity(earthData)
            RoversEnum.SPIRIT -> sendRequestImagesBySpirit(earthData)
        }

    }
    private fun sendRequestImagesByPerseverance(earthData: String){
        repositoryImp.getRoversApi().getPhotosOfByPerseverance(BuildConfig.NASA_API_KEY, earthData).enqueue(callback)
        Log.d("myTag", "sendRequestImagesByPerseverance: earthData = $earthData")
    }

    private fun sendRequestImagesByCuriosity(earthData: String){
        repositoryImp.getRoversApi().getPhotosOfByCuriosity(BuildConfig.NASA_API_KEY, earthData).enqueue(callback)
    }
    private fun sendRequestImagesByOpportunity(earthData: String){
        repositoryImp.getRoversApi().getPhotosOfByOpportunity(BuildConfig.NASA_API_KEY, earthData).enqueue(callback)
    }
    private fun sendRequestImagesBySpirit(earthData: String){
        repositoryImp.getRoversApi().getPhotosOfBySpirit(BuildConfig.NASA_API_KEY, earthData).enqueue(callback)
    }


    private val callback = object : Callback<PhotosOfSolByRoverResponseData> {
        override fun onResponse(call: Call<PhotosOfSolByRoverResponseData>, response: Response<PhotosOfSolByRoverResponseData>) {
            if(response.isSuccessful && response.body() != null){
                liveDataToObserve.postValue(AppStatePhotosOfSolByRover.Success(response.body()!!))
                Log.d("myTag", "onResponse: ${response.body()}")
            }
            else{
                liveDataToObserve.postValue(AppStatePhotosOfSolByRover.Error(throw IllegalStateException("Пришел неверный ответ")))
            }
        }

        override fun onFailure(call: Call<PhotosOfSolByRoverResponseData>, t: Throwable) {
            TODO("Not yet implemented")
        }

    }
}

