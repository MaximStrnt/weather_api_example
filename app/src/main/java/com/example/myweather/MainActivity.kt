package com.example.myweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyInterface {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP_ACTIVITY = this

        val a = binding.locName
        val b = binding.tempIndex
        val c = binding.windIndex
        val d = binding.humIndex
        val e = binding.tvTargetName

       binding.btnEnter.setOnClickListener {
           val text = binding.spinnerName.selectedItem.toString()

           binding.loadingCircle.visibility = View.INVISIBLE
           initWeather(text, a, b, c, d, e)
       }
    }

}