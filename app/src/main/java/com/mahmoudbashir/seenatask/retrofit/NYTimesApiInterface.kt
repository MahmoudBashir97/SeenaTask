package com.mahmoudbashir.seenatask.retrofit

import com.mahmoudbashir.seenatask.pojo.PopularData_Model
import com.mahmoudbashir.seenatask.utils.Constants
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NYTimesApiInterface {

    @Headers("Accept: application/json")
    @GET("svc/mostpopular/v2/viewed/7.json")
    fun getPopularArticles(
        @Query("api-key")
        apiKey:String = Constants.API_KEY
    ): Observable<PopularData_Model>

}