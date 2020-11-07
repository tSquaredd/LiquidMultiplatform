package com.tsquaredapps.liquidmultiplatform.androidApp.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T> : ViewModel() {
    protected val state = SingleEventLiveData<T>()
    val stateLiveData: LiveData<T>
        get() = state
}