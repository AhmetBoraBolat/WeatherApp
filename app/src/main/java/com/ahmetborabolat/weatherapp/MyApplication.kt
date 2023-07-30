package com.ahmetborabolat.weatherapp

import android.app.Application

class MyApplication : Application() {




    companion object{
    lateinit var instance : MyApplication
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    override fun onTerminate() {
        super.onTerminate()

        //val sharedPrefs : SharedPrefs.geti
    }
}