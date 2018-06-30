package org.snakeskin.compiler

import java.io.*
import javax.annotation.processing.ProcessingEnvironment
import javax.tools.Diagnostic
import javax.tools.JavaFileManager

class ServiceRegistrationManager(val env: ProcessingEnvironment, val className: String) {
    private val classes = mutableSetOf<String>()
    private val lines = arrayListOf<String>()

    private fun getFileName(): String {
        return "META-INF/services/$className"
    }

    private fun read(reader: Reader) {
        reader.forEachLine {
            if (!it.isEmpty() && it.first() != '#') {
                if (classes.add(it)) {
                    lines.add(it)
                }
            } else {
                lines.add(it)
            }
        }
    }

    fun read(location: JavaFileManager.Location) {
        val fileName = getFileName()

        try {
            val filer = env.filer
            val file = filer.getResource(location, "", fileName)

            if (file.lastModified != 0L) {
                val reader = InputStreamReader(file.openInputStream())
                read(reader)
                reader.close()
            }
        } catch (e: Exception) {}
    }

    fun addClass(className: String) {
        if (classes.add(className)) {
            lines.add(className)
            env.messager.printMessage(Diagnostic.Kind.NOTE, "[SnakeSkin] Registered wrapper class '$className'")
        }
    }

    fun write(writer: Writer) {
        val pw = PrintWriter(writer)
        lines.forEach {
            pw.println(it)
        }
        pw.flush()
        pw.close()
    }

    fun write(location: JavaFileManager.Location) {
        try {
            val file = env.filer.createResource(location, "", getFileName())
            write(file.openWriter())
        } catch (e: Exception) {}
    }
}