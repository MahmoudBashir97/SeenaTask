package com.mahmoudbashir.seenatask.repository

import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import retrofit2.Response

interface IRepository {

    suspend fun getPopularTimes(): Response<PopularData_Model>
}