package com.kelvin.parkr.ui

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment()

// Pager subclass - May want to break out into own file if more logic added
abstract class BasePagerFragment (val tabTitle: String?) : BaseFragment()