package com.example.space.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.BuildConfig
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.model.marsRoverPhotos.photos.PhotosOfSolByRoverResponseData
import com.example.space.repositorys.repositoryRovers.RepositoryRoverImp
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

    fun sendRequestImagesByRover(earthData: String) {
        Log.d("MarsImagesViewModel_earthData", "sendRequestImagesByRover: $earthData ")
        repositoryImp.getRoversApi().getPhotosOfByPerseverance(BuildConfig.NASA_API_KEY, earthData).enqueue(callback)
        Log.d("MarsImagesViewModel", "sendRequestImagesByRover:  $repositoryImp.getRoversApi().getPhotosOfByPerseverance(BuildConfig.NASA_API_KEY, earthData).enqueue(callback)")
        Log.d("MarsImagesViewModel", "sendRequestImagesByRover:  $repositoryImp.getRoversApi().getPhotosOfByPerseverance(BuildConfig.NASA_API_KEY, earthData)")
    }

    private val callback = object : Callback<PhotosOfSolByRoverResponseData> {
        override fun onResponse(call: Call<PhotosOfSolByRoverResponseData>, response: Response<PhotosOfSolByRoverResponseData>) {
            if(response.isSuccessful && response.body() != null){
                liveDataToObserve.postValue(AppStatePhotosOfSolByRover.Success(response.body()!!))
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

