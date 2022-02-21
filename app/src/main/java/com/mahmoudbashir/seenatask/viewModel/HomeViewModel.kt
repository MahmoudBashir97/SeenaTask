package com.mahmoudbashir.seenatask.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import com.mahmoudbashir.seenatask.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class HomeViewModel @Inject constructor(val app :Application, val repo:Repository): AndroidViewModel(app){

    val pop : MutableLiveData<PopularData_Model> = MutableLiveData()

     fun getPopular() = viewModelScope.launch {

         try {
             repo.getPopularTimes().body().let { model ->
                 if (model != null) {
                     pop.postValue(model)
                 }
             }
         }catch (e:Exception){
             Log.e("erroIngetting : ","error :  ${e.message}")
         }

    }
}