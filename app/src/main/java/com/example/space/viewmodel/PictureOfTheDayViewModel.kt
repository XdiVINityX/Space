package com.example.space.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.BuildConfig
import com.example.space.model.PictureOfTheDayResponseData
import com.example.space.model.RepositoryImp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val repositoryImp: RepositoryImp = RepositoryImp(),
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()
) : ViewModel() {





    fun getLiveData():MutableLiveData<AppState>{
        return liveData
    }


    fun sentRequest() {

        repositoryImp.getPictureOfTheDayApi().getPictureOfTheDay(BuildConfig.NASA_API_KEY)
            //Выполняем ассинхронно и пишем куда придет ответ.
            .enqueue(callback)
    }

    private val callback = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ) {
            if (response.isSuccessful) {
                //Это ответ(удачный) - response.body()!!
                liveData.postValue(AppState.Success(response.body()!!))
            } else liveData.postValue(AppState.Error(throw IllegalStateException("Пришел не верный ответ")))


        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            //Тут обработать ошибки
            //TODO HW
        }

    }

}