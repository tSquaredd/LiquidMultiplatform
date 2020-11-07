package com.tsquaredapps.liquidmultiplatform.shared.setup.information.resources

import com.tsquaredapps.liquidmultiplatform.MR
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

class UserInformationResourcesImpl : UserInformationResources {
    override val weightErrorMessage: StringDesc
        get() = StringDesc.Resource(MR.strings.weight_error_message)
}