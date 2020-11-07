package com.tsquaredapps.liquidmultiplatform.shared.setup.information

import com.tsquaredapps.liquidmultiplatform.shared.common.LiquidUnit
import dev.icerock.moko.resources.desc.StringDesc

sealed class UserInformationState {
    object Started : UserInformationState()
    class InvalidWeight(val errorMessage: StringDesc) : UserInformationState()
    class Continue(val weight: Int, val unitChoiceState: LiquidUnit) : UserInformationState()
    object OzSelected : UserInformationState()
    object MlSelected : UserInformationState()
}