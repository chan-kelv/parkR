package com.kelvin.parkr.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kelvin.parkr.ui.BasePagerFragment

/**
 * Created by Kelvin Chan on 2019-09-22.
 */
class DashboardViewModel: BaseViewModel() {
    private var dashboardFragmentsVm: MutableLiveData<MutableList<BasePagerFragment>> = MutableLiveData(mutableListOf())

    fun getDashboardFragments(): LiveData<MutableList<BasePagerFragment>> {
        return dashboardFragmentsVm
    }

    /*
     * If there is a need to dynamically add another fragment
     */
    fun addPagerFragment(fragment: BasePagerFragment) {
        if (dashboardFragmentsVm.value == null) {
            dashboardFragmentsVm.value = mutableListOf()
        }

        dashboardFragmentsVm.value?.add(fragment)
        dashboardFragmentsVm.notifyObserver()
    }

    fun setPagerFragments(fragments: MutableList<BasePagerFragment>) {
        dashboardFragmentsVm.value = fragments
    }
}