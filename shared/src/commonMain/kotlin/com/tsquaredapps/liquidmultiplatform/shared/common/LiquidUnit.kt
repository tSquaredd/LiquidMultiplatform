package com.tsquaredapps.liquidmultiplatform.shared.common

import kotlin.math.roundToInt

enum class LiquidUnit {
    OZ, ML;

    override fun toString(): String = this.name.toLowerCase()
}

fun calculateDailyGoal(unit: LiquidUnit, weight: Int) =
    if (unit == LiquidUnit.OZ) (weight / 2.0).roundToInt()
    else ((weight / 2) * 29.5375).roundToInt()

fun convertOzToMl(oz: Double) = oz * 29.5375

fun convertMlToOz(ml: Double) = ml / 29.5375