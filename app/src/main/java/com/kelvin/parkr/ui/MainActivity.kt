package com.kelvin.parkr.ui

import android.os.Bundle
import com.kelvin.parkr.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()

        setupMainViewPager()
    }

    private fun setupMainViewPager() {
        replaceFragment(frame_main.id, DashboardFragment())
    }

    private fun setupToolbar() {
        // TODO in #18
    }
}
