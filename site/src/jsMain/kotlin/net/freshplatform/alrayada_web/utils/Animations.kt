package net.freshplatform.alrayada_web.utils

import kotlinx.coroutines.delay

/**
 * Animate from 0 to $toNumber and it will be affected by $delayTime
 * */
suspend fun animateNumber(
    number: Int,
    delayTime: Long = 10L,
    onUpdate: (Int) -> Unit
) {
    (0..number).forEach { currentValue ->
        delay(delayTime)
        onUpdate(currentValue)
    }
}