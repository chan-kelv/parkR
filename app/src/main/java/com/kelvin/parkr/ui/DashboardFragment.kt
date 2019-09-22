package com.kelvin.parkr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kelvin.parkr.R
import com.kelvin.parkr.ui.adapter.DashboardPagerAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment: BaseFragment() {
    private lateinit var dashboardPagerAdapter: DashboardPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupParkPagerAdapter()
        setupParkTabs()
    }

    private fun setupParkPagerAdapter() {
        dashboardPagerAdapter = DashboardPagerAdapter(childFragmentManager)
        pager_dashboard.adapter = dashboardPagerAdapter
    }

    private fun setupParkTabs() {
        tab_dashboard.setupWithViewPager(pager_dashboard)

        val tabParkNow = layoutInflater.inflate(R.layout.tab_template, tab_dashboard, false)
        tabParkNow.findViewById<ImageView>(R.id.img_tab_icon).setImageResource(R.drawable.ic_car)
        tab_dashboard.getTabAt(0)?.customView = tabParkNow

        val tabParkInProgress = layoutInflater.inflate(R.layout.tab_template, tab_dashboard, false)
        tabParkInProgress.findViewById<ImageView>(R.id.img_tab_icon).setImageResource(R.drawable.ic_parking)
        tab_dashboard.getTabAt(1)?.customView = tabParkInProgress
    }
}