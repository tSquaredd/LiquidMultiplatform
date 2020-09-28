package com.tsquaredapps.liquidmutliplatform.shared.setup.welcome

import com.tsquaredapps.liquidmutliplatform.MR
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

class WelcomeResourcesImpl : WelcomeResources {
    override val welcomeMessage: StringDesc
        get() = StringDesc.Resource(MR.strings.welcome_message)

    override val buttonText: StringDesc
        get() = StringDesc.Resource(MR.strings.lets_get_started)
}