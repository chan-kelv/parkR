package com.kelvin.parkr.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity: AppCompatActivity() {
    protected var mCurrentVisibleFragment: Fragment? = null

    protected fun replaceFragment(activityContainerId: Int, fragment: Fragment, backstackTag: String? = null, args: Bundle? = null) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        // Optional: add fun animations
        args?.let { fragment.arguments = it }

        // Optional: add to backstack with tag
        backstackTag?.let { fragmentTransaction.addToBackStack(it) }

        fragmentTransaction.replace(activityContainerId, fragment).commit()
        mCurrentVisibleFragment = fragment
    }
}