package com.mahmoudbashir.seenatask.repository

import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import com.mahmoudbashir.seenatask.retrofit.RetrofitInstance
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import javax.inject.Inject

class Repository : IRepository {
    override  fun getPopularTimes(): Observable<PopularData_Model> = RetrofitInstance.api.getPopularArticles()
}