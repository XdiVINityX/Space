package com.example.space.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.BuildConfig
import com.example.space.utils.DataProviderImpl
import com.example.space.model.pictureOfTheDay.PictureOfTheDayResponseData
import com.example.space.repositorys.pictureOfTheDay.RepositoryPictureOfTheDayImp
import com.example.space.viewmodel.appState.AppStatePictureOfTheDay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val repositoryImp: RepositoryPictureOfTheDayImp = RepositoryPictureOfTheDayImp(),
    private val liveData: MutableLiveData<AppStatePictureOfTheDay> = MutableLiveData<AppStatePictureOfTheDay>(),
    private val dateProviderImp : DataProviderImpl = DataProviderImpl()
) : ViewModel() {


    fun getLiveData(): MutableLiveData<AppStatePictureOfTheDay> {
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
                //Это ответ(удачный) - response.body()!! Одако тело все равно может быть пустое, а значит может быть null WARNING
                liveData.postValue(AppStatePictureOfTheDay.Success(response.body()!!))
            } else {
                liveData.postValue(AppStatePictureOfTheDay.Error(throw IllegalStateException("Пришел неверный ответ")))
            }
        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            //Тут обработать ошибки
            //TODO HW
        }

    }

}