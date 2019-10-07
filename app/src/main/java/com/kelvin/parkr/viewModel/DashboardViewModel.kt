package com.kelvin.parkr.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kelvin.parkr.ui.BasePagerFragment

/**
 * Created by Kelvin Chan on 2019-09-22.
 */
class DashboardViewModel: BaseViewModel() {
    private var dashboardFragmentsViewModel: MutableLiveData<MutableList<BasePagerFragment>> = MutableLiveData(mutableListOf())

    fun getDashboardFragments(): LiveData<MutableList<BasePagerFragment>> {
        return dashboardFragmentsViewModel
    }

    /*
     * If there is a need to dynamically add another fragment
     */
    fun addPagerFragment(fragment: BasePagerFragment) {
        if (dashboardFragmentsViewModel.value == null) {
            dashboardFragmentsViewModel.value = mutableListOf()
        }

        dashboardFragmentsViewModel.value?.add(fragment)
        dashboardFragmentsViewModel.notifyObserver()
    }

    fun setPagerFragments(fragments: MutableList<BasePagerFragment>) {
        dashboardFragmentsViewModel.value = fragments
    }
}