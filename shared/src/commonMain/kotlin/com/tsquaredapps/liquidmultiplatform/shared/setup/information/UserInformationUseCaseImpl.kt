package com.tsquaredapps.liquidmultiplatform.shared.setup.information

import com.tsquaredapps.liquidmultiplatform.shared.common.LiquidUnit
import com.tsquaredapps.liquidmultiplatform.shared.common.StateUseCase
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.UserInformationState.OzSelected
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.UserInformationState.Started
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.resources.UserInformationResources
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class UserInformationUseCaseImpl(
    private val resources: UserInformationResources,
    iosUpdate: ((UserInformationState) -> Unit)? = null
) : StateUseCase<UserInformationState>(Started, iosUpdate = iosUpdate) {

    private var selectedUnit = LiquidUnit.OZ

    fun onUnitSelected(choice: LiquidUnit) {
        selectedUnit = choice
        setState(if (selectedUnit == LiquidUnit.OZ) OzSelected else UserInformationState.MlSelected)
    }

    fun onContinueClicked(weightInput: String?) {
        val weight = weightInput?.toIntOrNull()
        if (weight == null) {
            setState(
                UserInformationState.InvalidWeight(
                    resources.weightErrorMessage
                )
            )
        } else {
            setState(
                UserInformationState.Continue(
                    weight,
                    selectedUnit
                )
            )
        }
    }
}