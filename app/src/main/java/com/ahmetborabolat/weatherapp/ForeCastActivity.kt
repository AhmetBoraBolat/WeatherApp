package com.ahmetborabolat.weatherapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ahmetborabolat.weatherapp.adapter.ForeCastAdapter
import com.ahmetborabolat.weatherapp.model.WeatherList
import com.ahmetborabolat.weatherapp.mvvm.WeatherVm
import androidx.lifecycle.Observer


class ForeCastActivity : AppCompatActivity() {
    private lateinit var adapterForeCastAdapter: ForeCastAdapter
    lateinit var viM : WeatherVm
    lateinit var rvForeCast: RecyclerView


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fore_cast)


        viM = ViewModelProvider(this).get(WeatherVm::class.java)


        adapterForeCastAdapter = ForeCastAdapter()

        rvForeCast = findViewById<RecyclerView>(R.id.rvForeCast)


        val sharedPrefs = SharedPrefs.getInstance(this)
        val city = sharedPrefs.getValueOrNull("city")


        Log.d("Prefs", city.toString())



        if (city!=null){


            viM.getForecastUpcoming(city)

        } else {

            viM.getForecastUpcoming()


        }




        viM.forecastWeatherLiveData.observe(this, Observer {

            val setNewlist = it as List<WeatherList>



            Log.d("Forecast LiveData", setNewlist.toString())



            adapterForeCastAdapter.setList(setNewlist)


            rvForeCast.adapter = adapterForeCastAdapter



        })





    }

}