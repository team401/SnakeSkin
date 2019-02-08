package org.snakeskin.compiler.units

/**
 * @author Cameron Earle
 * @version 2/6/2019
 *
 */
class UnitDefinition(val isBase: Boolean, val group: String, val name: String, val abbreviation: String, vararg val components: UnitComponent) {
    companion object {
        fun createSingle(isBase: Boolean, group: String, component: UnitComponent): UnitDefinition {
            return UnitDefinition(isBase, group, component.pluralName, component.abbreviation, component)
        }
    }

    fun createPer(isBase: Boolean, group: String, component: UnitComponent): UnitDefinition {
        return UnitDefinition(isBase, group, "${this.name}Per${component.name}", "${this.abbreviation}/${component.name}", *components, component.divide())
    }

    override fun toString(): String {
        return "{$group.$name} (${components.map { it.toString() }})"
    }
}