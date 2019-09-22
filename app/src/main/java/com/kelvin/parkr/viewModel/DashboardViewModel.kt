package com.kelvin.parkr.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kelvin.parkr.ui.BasePagerFragment

/**
 * Created by Kelvin Chan on 2019-09-22.
 */
class DashboardViewModel: BaseViewModel() {
    private var dashboardFragmentsVm: MutableLiveData<MutableList<BasePagerFragment>?>
            = MutableLiveData(null)

    fun getDashboardFragmets(): LiveData<MutableList<BasePagerFragment>?> {
        return dashboardFragmentsVm
    }

    fun addPagerFragment(fragment: BasePagerFragment) {
        if (dashboardFragmentsVm.value == null) {
            dashboardFragmentsVm.value = mutableListOf()
        }

        dashboardFragmentsVm.value?.add(fragment)
        dashboardFragmentsVm.notifyObserver()
    }

    fun addPagerFragments(fragments: MutableList<BasePagerFragment>?) {
        dashboardFragmentsVm.value = fragments
    }
}