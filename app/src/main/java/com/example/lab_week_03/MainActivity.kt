package com.example.lab_week_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

interface CoffeeListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), CoffeeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSelected(id: Int) {
        val detailFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_detail) as? DetailFragment
        detailFragment?.setCoffeeData(id)
    }
}