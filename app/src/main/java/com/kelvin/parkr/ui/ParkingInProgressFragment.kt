package com.kelvin.parkr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelvin.parkr.R

class ParkingInProgressFragment : BasePagerFragment("In Progress", R.drawable.ic_parking) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_parking_in_progress, container, false)
    }
}
