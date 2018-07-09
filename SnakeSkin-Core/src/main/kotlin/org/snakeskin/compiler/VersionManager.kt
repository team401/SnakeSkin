package org.snakeskin.compiler

import java.util.*

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