package com.example.space.view.bottomBar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space.repositorys.pictureOfTheDay.RepositoryPictureOfTheDayImp
import com.example.space.viewmodel.AppState

class MarsRoversViewModel(
    private val liviDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImp: RepositoryPictureOfTheDayImp = RepositoryPictureOfTheDayImp()

) : ViewModel() {

}