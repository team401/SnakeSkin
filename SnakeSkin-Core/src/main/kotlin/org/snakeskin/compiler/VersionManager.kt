package org.snakeskin.compiler

import java.util.*

/*
 * snakeskin - Created on 6/30/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 6/30/18
 */
object VersionManager {
    private val versionInternal: String? by lazy {
        val stream = javaClass.classLoader.getResourceAsStream("META-INF/snakeskin-version.properties")
        val prop = Properties()
        if (stream != null) {
            try {
                prop.load(stream)
                prop.getProperty("core", null)
            } catch (e: Exception) {
                null
            }
        } else {
            null
        }
    }

    /**
     * Gets the current version of SnakeSkin-Core that is in the classpath
     */
    fun getVersion(): String {
        return versionInternal ?: "UNKNOWN"
    }
}