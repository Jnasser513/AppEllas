package com.nasser.appellas.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val APP_API_BASE_URL = "https://agile-gorge-55718.herokuapp.com//api/"

private val retrofit = Retrofit.Builder()
    .baseUrl(APP_API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object AppApi {
    val service by lazy {
        retrofit.create(AppService::class.java)
    }

}