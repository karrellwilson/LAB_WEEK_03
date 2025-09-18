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

        // Tampilkan ListFragment saat activity pertama kali dibuat
        if (savedInstanceState == null) {
            val listFragment = ListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, listFragment)
                .commit()
        }
    }

    override fun onSelected(id: Int) {
        // Buat instance DetailFragment menggunakan newInstance
        val detailFragment = DetailFragment.newInstance(id)

        // Ganti ListFragment dengan DetailFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            // Tambahkan transaksi ini ke back stack agar bisa kembali
            .addToBackStack(null)
            .commit()
    }
}