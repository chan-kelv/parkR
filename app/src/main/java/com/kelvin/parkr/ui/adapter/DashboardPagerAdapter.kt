package com.kelvin.parkr.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kelvin.parkr.ui.ParkNowFragment
import com.kelvin.parkr.ui.ParkingInProgressFragment

class DashboardPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = listOf(
        ParkNowFragment(),
        ParkingInProgressFragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position < fragments.size) {
            return fragments[position].tabTitle
        }
        return null
    }

}