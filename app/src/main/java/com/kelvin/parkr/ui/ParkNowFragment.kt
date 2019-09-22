package com.kelvin.parkr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelvin.parkr.R

class ParkNowFragment : BasePagerFragment("Park Now", R.drawable.ic_car) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_park_now, container, false)
    }
}