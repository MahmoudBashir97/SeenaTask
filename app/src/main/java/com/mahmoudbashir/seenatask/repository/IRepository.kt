package com.mahmoudbashir.seenatask.repository

import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

interface IRepository {

     fun getPopularTimes(): Observable<PopularData_Model>
}