package com.tsquaredapps.liquidmultiplatform.shared.common

import kotlinx.coroutines.*
import platform.Foundation.*
import platform.UIKit.*
import platform.darwin.*
import kotlin.coroutines.*

@InternalCoroutinesApi
internal actual fun dispatcher(): CoroutineDispatcher = UI

@InternalCoroutinesApi
private object UI : CoroutineDispatcher(), Delay {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        val queue = dispatch_get_main_queue()
        dispatch_async(queue) {
            block.run()
        }
    }

    @ExperimentalUnsignedTypes
    @ExperimentalCoroutinesApi
    override fun scheduleResumeAfterDelay(
        timeMillis: Long,
        continuation: CancellableContinuation<Unit>
    ) {
        val queue = dispatch_get_main_queue()

        val time = dispatch_time(DISPATCH_TIME_NOW, (timeMillis * NSEC_PER_MSEC.toLong()))
        dispatch_after(time, queue) {
            with(continuation) {
                resumeUndispatched(Unit)
            }
        }
    }
}

internal actual fun generateUserId(): String =
    (UIDevice.currentDevice.identifierForVendor ?: NSUUID.UUID()).UUIDString