package com.example.epass.Model

import androidx.lifecycle.ViewModel
import com.example.epass.R


data class HomeModel(
    var selectmode: Int = 0,
    var heropage: Int = 1,
    var From: String = "",
    var To: String = "",
) : ViewModel() {
    var sliderState = listOf(
        R.drawable.place,
        R.drawable.place1,
        R.drawable.place2,
        R.drawable.place3,
        R.drawable.place4
    );
    var Mode = listOf(
        Pair("Trains", R.drawable.railway),
        Pair("Flights", R.drawable.airplane),
        Pair("Buses", R.drawable.bus),
        Pair("Taxi", R.drawable.taxi),
        Pair("Hotels", R.drawable.hotel)
    );

}