package org.snakeskin.component.provider

/**
 * Represents a component that can follow another.
 */
interface IFollowProvider {
    /**
     * Follows a master component
     */
    fun follow(master: IFollowableProvider)
}