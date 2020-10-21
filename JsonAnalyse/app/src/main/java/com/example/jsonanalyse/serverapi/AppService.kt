package com.example.jsonanalyse.serverapi

import com.example.jsonanalyse.MyData
import com.example.jsonanalyse.MyDataList
import retrofit2.Call
import retrofit2.http.GET

interface AppService {
    @GET("get_json")
    fun getData(): Call<MyDataList>
}