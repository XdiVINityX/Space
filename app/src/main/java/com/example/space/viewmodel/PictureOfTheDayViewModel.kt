package com.example.space.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.BuildConfig
import com.example.space.model.DataProviderImpl
import com.example.space.model.PictureOfTheDayResponseData
import com.example.space.model.RepositoryImp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val repositoryImp: RepositoryImp = RepositoryImp(),
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>(),
    private val dateProviderImp : DataProviderImpl = DataProviderImpl()
) : ViewModel() {


    fun getLiveData(): MutableLiveData<AppState> {
        return liveData
    }

    fun sentRequest(enum: PictureOfTheDayEnum) {

        //TODO Иногда приходит не изображение а видео, обработать этот вариант  к примеру. https://www.youtube.com/embed/X4UF9Akman0?rel=0%22

        when (enum) {
            PictureOfTheDayEnum.TODAY ->
                repositoryImp
                    .getPictureOfTheDayApi()
                    .getPictureOfTheDay(BuildConfig.NASA_API_KEY)
                    //Выполняем ассинхронно и пишем куда придет ответ.
                    .enqueue(callback)
            PictureOfTheDayEnum.YESTERDAY ->
                repositoryImp
                    .getPictureOfTheDayApi()
                    .getPictureOfTheDayWithDate(BuildConfig.NASA_API_KEY, dateProviderImp.getYesterday())
                    .enqueue(callback)
            PictureOfTheDayEnum.DAY_BEFORE_YESTERDAY ->
                repositoryImp
                    .getPictureOfTheDayApi()
                    .getPictureOfTheDayWithDate(BuildConfig.NASA_API_KEY, dateProviderImp.getDayBeforeYesterday())
                    .enqueue(callback)
        }
    }

    private val callback = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ) {
            if (response.isSuccessful) {
                //Это ответ(удачный) - response.body()!!
                liveData.postValue(AppState.Success(response.body()!!))
            } else {
                liveData.postValue(AppState.Error(throw IllegalStateException("Пришел неверный ответ")))
            }


        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            //Тут обработать ошибки
            //TODO HW
        }

    }

}