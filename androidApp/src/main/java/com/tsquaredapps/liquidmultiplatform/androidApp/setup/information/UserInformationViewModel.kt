package com.tsquaredapps.liquidmultiplatform.androidApp.setup.information

import androidx.lifecycle.viewModelScope
import com.tsquaredapps.liquidmultiplatform.androidApp.common.BaseViewModel
import com.tsquaredapps.liquidmultiplatform.shared.common.LiquidUnit
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.UserInformationState
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.UserInformationUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class UserInformationViewModel
@Inject constructor(private val useCase: UserInformationUseCaseImpl) :
    BaseViewModel<UserInformationState>() {

    init {
        viewModelScope.launch {
            useCase.stateFlow.collect {
                state.value = it
            }
        }
    }

    fun onUnitSelected(choice: LiquidUnit) {
        useCase.onUnitSelected(choice = choice)
    }

    fun onContinueClicked(weightInput: String?) {
        useCase.onContinueClicked(weightInput)
    }
}