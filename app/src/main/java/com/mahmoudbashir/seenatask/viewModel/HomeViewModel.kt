package com.mahmoudbashir.seenatask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import com.mahmoudbashir.seenatask.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class HomeViewModel @Inject constructor(val repo:Repository): ViewModel(){
    val pop : MutableLiveData<PopularData_Model> = MutableLiveData()
    suspend fun getPopular() {
        repo.getPopularTimes().body().let { model ->
            if (model != null){
                pop.postValue(model)
            }
        }

    }
}