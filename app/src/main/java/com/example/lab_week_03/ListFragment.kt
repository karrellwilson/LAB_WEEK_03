package com.example.lab_week_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeList: List<View> = listOf(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.espresso), // DITAMBAHKAN
            view.findViewById(R.id.macchiato)  // DITAMBAHKAN
        )

        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                val fragmentBundle = Bundle()
                fragmentBundle.putInt(COFFEE_ID, coffee.id)
                findNavController().navigate(R.id.coffee_id_action, fragmentBundle)
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}