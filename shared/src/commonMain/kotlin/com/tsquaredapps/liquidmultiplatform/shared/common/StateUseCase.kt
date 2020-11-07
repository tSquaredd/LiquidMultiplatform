package com.tsquaredapps.liquidmultiplatform.shared.common

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@ExperimentalCoroutinesApi
open class StateUseCase<T>(initialState: T, private val iosUpdate: ((T) -> Unit)? = null) {

    private val mutableStateFlow = MutableStateFlow(initialState)
    val stateFlow: Flow<T> = mutableStateFlow

    fun setState(state: T) {
        mutableStateFlow.value = state
        iosUpdate?.let { it(state) }
    }
}