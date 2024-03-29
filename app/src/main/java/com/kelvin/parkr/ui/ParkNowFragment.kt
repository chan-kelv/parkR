package com.kelvin.parkr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelvin.parkr.R

class ParkNowFragment : BasePagerFragment(PARK_NOW_TITLE, R.drawable.ic_car) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_park_now, container, false)
    }

    companion object {
        private const val PARK_NOW_TITLE = "Park Now"
    }
}
