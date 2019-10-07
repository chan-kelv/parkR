package com.kelvin.parkr

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kelvin.parkr.ui.BasePagerFragment
import com.kelvin.parkr.viewModel.DashboardViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class DashboardVMTest {
    private lateinit var dashboardVm: DashboardViewModel

    // This rule is needed to run live data observers https://stackoverflow.com/a/49840604
    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        dashboardVm = DashboardViewModel()
    }

    @Test
    fun getDashboardFragments_addFragment_sizeIncrease() {
        Assert.assertNotNull(dashboardVm.getDashboardFragments())

        // Initial value should be zero
        val fragments = dashboardVm.getDashboardFragments().value
        Assert.assertNotNull(fragments)
        Assert.assertEquals(0, fragments?.size)

        // Add fragments
        val mockFrag1 = mock(BasePagerFragment::class.java)
        dashboardVm.addPagerFragment(mockFrag1)
        Assert.assertEquals(1, fragments?.size)
    }

    @Test
    fun addPagerFragment_addMultiFragments_sizeUpdates() {
        Assert.assertEquals(0, dashboardVm.getDashboardFragments().value?.size)

        // Add fragments
        val mockFrag1 = mock(BasePagerFragment::class.java)
        val mockFrag2 = mock(BasePagerFragment::class.java)

        dashboardVm.addPagerFragment(mockFrag1)
        dashboardVm.addPagerFragment(mockFrag2)
        Assert.assertEquals(2, dashboardVm.getDashboardFragments().value?.size)

        val mockFrag3 = mock(BasePagerFragment::class.java)
        dashboardVm.addPagerFragment(mockFrag3)
        Assert.assertEquals(3, dashboardVm.getDashboardFragments().value?.size)

        dashboardVm.setPagerFragments(mutableListOf())
        Assert.assertEquals(0, dashboardVm.getDashboardFragments().value?.size)
    }
}
