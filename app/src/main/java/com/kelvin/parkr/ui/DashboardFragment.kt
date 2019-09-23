package com.kelvin.parkr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kelvin.parkr.R
import com.kelvin.parkr.ui.adapter.DashboardPagerAdapter
import com.kelvin.parkr.viewModel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : BaseFragment() {
    private lateinit var dashboardVm: DashboardViewModel
    private lateinit var dashboardPagerAdapter: DashboardPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        dashboardVm = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        dashboardVm.getDashboardFragments().observe(this, dashboardRefreshObserver)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setup view pager
        setupParkPagerAdapter()
        setupParkTabs()

        addParkFragments()
    }

    private fun addParkFragments() {
        dashboardVm.addPagerFragments(
            mutableListOf(
                ParkNowFragment(),
                ParkingInProgressFragment()
            )
        )
    }

    /*
     * Creates a dashboard pager adapter and set it to the view pager
     */
    private fun setupParkPagerAdapter() {
        dashboardPagerAdapter = DashboardPagerAdapter(childFragmentManager)
        pager_dashboard.adapter = dashboardPagerAdapter
    }

    /*
     * Attaches the tab layout to the view pager
     */
    private fun setupParkTabs() {
        tab_dashboard.setupWithViewPager(pager_dashboard)
    }

    /*
     * Observers changes to the list of dashboard fragments and refreshes the view and tabs
     */
    private val dashboardRefreshObserver: Observer<MutableList<BasePagerFragment>> = Observer {
        if (it.isNotEmpty()) {
            dashboardPagerAdapter.refreshPagerFragments(it)

            // Set tab icons
            dashboardVm.getDashboardFragments().value?.let { dashboardFragments ->
                for (index in 0 until dashboardFragments.size) {
                    dashboardFragments[index].tabIconRes?.let { iconRes ->
                        activity?.runOnUiThread {
                            val tabIcon =
                                layoutInflater.inflate(R.layout.tab_template, tab_dashboard, false)
                            tabIcon.findViewById<ImageView>(R.id.img_tab_icon)
                                .setImageResource(iconRes)
                            tab_dashboard.getTabAt(index)?.customView = tabIcon
                        }
                    }
                }
            }
        }
    }
}
