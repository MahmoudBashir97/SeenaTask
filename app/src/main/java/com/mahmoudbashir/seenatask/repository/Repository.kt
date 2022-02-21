package com.mahmoudbashir.seenatask.repository

import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import com.mahmoudbashir.seenatask.retrofit.RetrofitInstance
import retrofit2.Response
import javax.inject.Inject

class Repository : IRepository {
    override suspend fun getPopularTimes(): Response<PopularData_Model>  = RetrofitInstance.api.getPopularArticles()
}