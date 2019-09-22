package com.kelvin.parkr.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}