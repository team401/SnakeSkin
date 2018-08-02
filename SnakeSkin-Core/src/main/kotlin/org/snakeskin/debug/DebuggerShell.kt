package org.snakeskin.debug

import groovy.lang.Binding
import groovy.lang.GroovyShell
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.io.PrintWriter

/**
 * @author Cameron Earle
 * @version 8/2/18
 */
class DebuggerShell(input: InputStream, output: OutputStream): Runnable {
    companion object {
        var basePackage = ""
    }

    private val reader = input.bufferedReader()
    private val writer = PrintStream(output)

    private val binding = Binding()
    private lateinit var shell: GroovyShell

    fun init() {
        val ic = ImportCustomizer()
        if (basePackage.isNotEmpty()) {
            ic.addStarImports(basePackage)
        }

        //SnakeSkin imports
        ic.addStarImports("org.snakeskin.dsl")
        ic.addStaticStars("org.snakeskin.dsl.EventKt")

        val config = CompilerConfiguration()
        config.addCompilationCustomizers(ic)

        shell = GroovyShell(this.javaClass.classLoader, binding, config)
    }

    override fun run() {
        while (!Thread.interrupted()) {
            try {
                val cmd = reader.readLine()
                val script = shell.parse(cmd)
                val ans = script.run()
                writer.println(ans)
                binding.setVariable("ans", ans)
            } catch (ix: InterruptedException) {
                Thread.currentThread().interrupt()
            } catch (e: Exception) {
                e.printStackTrace(writer)
            }
        }
    }
}