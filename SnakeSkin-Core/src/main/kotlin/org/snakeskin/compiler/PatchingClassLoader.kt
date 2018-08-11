package org.snakeskin.compiler

import org.snakeskin.logging.LogLevel
import org.snakeskin.logging.LoggerManager
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.URL
import java.net.URLClassLoader

/**
 * @author Cameron Earle
 * @version 8/10/2018
 *
 * The PatchingClassLoader can be used to load alternative implementations of classes under the alias of the original class.
 * Classes can be added by using the "addClass" method, and all of the classes can be loaded with the "patchAll" method
 *
 * Patched class files should be placed in the resources root, under a single subdirectory called "patches"
 * Patch class files should have the extension ".class.patch"
 */
object PatchingClassLoader: URLClassLoader(arrayOf<URL>(), ClassLoader.getSystemClassLoader()) {
    private fun readPatchClass(name: String): InputStream? {
        val patchPath = "patches/" + name.replace(".", "/") + ".class.patch"
        return this.getResourceAsStream(patchPath)
    }

    /**
     * Patches a specific class, loading the patch from the matching directory in the patches folder
     */
    override fun loadClass(name: String?): Class<*> {
        if (name != null) {
            val stream = readPatchClass(name)

            if (stream != null) {
                try {
                    val buf = stream.readBytes()
                    val len = buf.size

                    val defineClass = ClassLoader::class.java.getDeclaredMethod(
                            "defineClass",
                            String::class.java,
                            ByteArray::class.java,
                            Int::class.java,
                            Int::class.java
                    )
                    defineClass.isAccessible = true
                    defineClass.invoke(parent, name, buf, 0, len)
                } catch (e: Exception) {
                    LoggerManager.logMessage("Unable to patch class '$name'", LogLevel.ERROR)
                    LoggerManager.logThrowable(e)
                }
            } else {
                LoggerManager.logMessage("Patch requested for class '$name', but no patch file was found!", LogLevel.WARNING)
            }
        }

        return super.loadClass(name)
    }

    /**
     * Loads patches (if available) for the given classes
     */
    fun registerPatches(vararg classes: String) {
        classes.forEach {
            loadClass(it)
        }
    }
}