package com.example.jsonanalyse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private val baseURL = "https://www.fastmock.site/mock/320c72e079f23feee6c096c8cd8e703f/AHTest/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    inline fun <reified T>create(): T = create(T::class.java)
}