package com.mahmoudbashir.seenatask.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import com.mahmoudbashir.seenatask.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class HomeViewModel @Inject constructor(val app :Application, val repo:Repository): AndroidViewModel(app){

    val pop : MutableLiveData<PopularData_Model> = MutableLiveData()

     fun getPopular() {

         try {
             repo.getPopularTimes()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe({ model ->
                     if (model != null) {
                         pop.postValue(model)
                     }
                 }, { throwable ->
                     Log.e("error::", throwable.message ?: "onError")
                 }
                 )
         } catch (e: Exception) {
             Log.e("erroIngetting : ", "error :  ${e.message}")
         }
     }
}