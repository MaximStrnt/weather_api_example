package com.example.myweather

import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley 

interface MyInterface {

    fun initWeather(textSearch: String,
                    locView: TextView, tempView: TextView, windView: TextView, humView: TextView, targetView: TextView) {

        val urlReq = "" // URL 

        val request = JsonObjectRequest(
            Request.Method.GET, urlReq, null,
            { response ->
                try {
                    
                    // getting json objects and paremeters
                    val loc = response.getJSONObject("").getString("").toString()
                    val temp = response.getJSONObject("").getDouble("").toString()
                    val wind = response.getJSONObject("").getDouble("").toString()
                    val humidity = response.getJSONObject("").getInt("").toString()

                    changeStrings(locView, tempView, windView, humView, targetView,
                        loc, temp, wind, humidity, textSearch)

                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(
                        APP_ACTIVITY,
                        "Failed!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) { error -> error.printStackTrace() }
        val mRequestQueue: RequestQueue = Volley.newRequestQueue(APP_ACTIVITY)
        mRequestQueue.add(request)

    }

    fun changeStrings(locView: TextView, tempView: TextView, windView: TextView, humView: TextView, targetView: TextView,
                      loc: String, temp: String, wind: String, hum: String, target: String){
        targetView.text = target
        locView.text = loc
        tempView.text = temp
        windView.text = wind
        humView.text = hum
    }
}