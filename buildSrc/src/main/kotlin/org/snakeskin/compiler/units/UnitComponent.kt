package org.snakeskin.compiler.units

/**
 * @author Cameron Earle
 * @version 2/6/2019
 *
 */
class UnitComponent(val unit: UnitType, val name: String, val pluralName: String, val abbreviation: String, conversionToBase: Double, val behavior: MultiUnitBehavior = MultiUnitBehavior.MULTIPLY) {
    val conversionToBase = when (behavior) {
        MultiUnitBehavior.MULTIPLY -> conversionToBase
        MultiUnitBehavior.DIVIDE -> 1.0 / conversionToBase
    }

    val conversionFromBase = 1.0 / this.conversionToBase

    fun multiply(): UnitComponent {
        return UnitComponent(unit, name, pluralName, abbreviation, conversionToBase, MultiUnitBehavior.MULTIPLY)
    }

    fun divide(): UnitComponent {
        return UnitComponent(unit, name, pluralName, abbreviation, conversionToBase, MultiUnitBehavior.DIVIDE)
    }

    override fun toString(): String {
        when (behavior) {
            MultiUnitBehavior.MULTIPLY -> return "* $name"
            MultiUnitBehavior.DIVIDE -> return "/ $name"
        }
    }
}