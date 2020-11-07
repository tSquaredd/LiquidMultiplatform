package com.tsquaredapps.liquidmultiplatform.shared.common

import kotlinx.coroutines.*

@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect fun dispatcher(): CoroutineDispatcher

@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect fun generateUserId(): String