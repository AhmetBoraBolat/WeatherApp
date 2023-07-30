package com.ahmetborabolat.weatherapp.service

import com.ahmetborabolat.weatherapp.Utils
import com.ahmetborabolat.weatherapp.model.ForeCast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("forecast?")
    fun getCurrentWeather(
        @Query("lat")
        lat: String,
        @Query("lon")
        lon : String,
        @Query("appid")
        appid : String = Utils.API_KEY
    ) : Call<ForeCast>

    @GET("forecast?")
    fun getWeatherByCity(
        @Query("q")
        city : String,
        @Query("appid")
        appid : String = Utils.API_KEY
    ) : Call<ForeCast>

}