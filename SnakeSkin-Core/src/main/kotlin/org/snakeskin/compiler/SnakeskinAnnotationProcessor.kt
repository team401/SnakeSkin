package org.snakeskin.compiler

import java.io.IOException
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic
import javax.tools.StandardLocation

/**
 * @author Cameron Earle
 * @version 6/26/17
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8) //Java 8
@SupportedOptions(SnakeskinAnnotationProcessor.KAPT_KOTLIN_GENERATED) //kapt output directroy support
class SnakeskinAnnotationProcessor: AbstractProcessor() {
    companion object {
        const val KAPT_KOTLIN_GENERATED = "kapt.kotlin.generated"
        val SUPPORTED_ANNOTATIONS = arrayOf(
                "org.snakeskin.annotation.Setup",
                "org.snakeskin.annotation.PreStartup",
                "org.snakeskin.annotation.PostStartup"
        )
        const val ANNOTATED_RUNNABLE = "org.snakeskin.compiler.AnnotatedRunnable"
    }

    private var registrationManager: ServiceRegistrationManager? = null

    /**
     * Registers the classes for our found methods in the service registry
     * This allows the ServiceLoader to find them at runtime
     */
    private fun registerClasses(classes: List<String>) {

        //registrationManager.read(StandardLocation.SOURCE_PATH)
        //registrationManager.read(StandardLocation.CLASS_PATH)
        classes.forEach {
            registrationManager?.addClass(it)
        }
        //registrationManager.write(StandardLocation.CLASS_OUTPUT)
    }

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment): Boolean {
        if (registrationManager == null) registrationManager = ServiceRegistrationManager(processingEnv, ANNOTATED_RUNNABLE)
        if (annotations == null || annotations.isEmpty()) return false
        val elements = processingEnv.elementUtils

        SUPPORTED_ANNOTATIONS.forEach {
            val annotation = elements.getTypeElement(it)

            if (annotation != null) { //The annotation is in this round, start processing
                val methods = roundEnv.getElementsAnnotatedWith(annotation)
                val generator = AnnotatedRunnableGenerator(processingEnv, it)
                val classes = ArrayList<String>(methods.size)
                methods.forEach {
                    val modifiers = it.modifiers
                    if (it.kind == ElementKind.METHOD) {
                        val executable = it as ExecutableElement
                        val qualifiedName = AnnotatedRunnableGenerator.getMethodQualifiedName(executable)
                        if (modifiers.contains(Modifier.PUBLIC) && modifiers.contains(Modifier.STATIC)) {
                            classes.add(generator.generate(executable))
                            System.out.println("[SnakeSkin] Wrapped method '$qualifiedName' (${annotation.simpleName})")
                        } else {
                            System.err.println("[SnakeSkin] Method '$qualifiedName' must be public and static")
                        }
                    }
                }
                if (classes.isNotEmpty()) { //Only write to services if there are classes
                    registerClasses(classes)
                }
            }
        }

        //registrationManager?.read(StandardLocation.SOURCE_PATH)
        //registrationManager?.read(StandardLocation.CLASS_PATH)
        registrationManager?.write(StandardLocation.CLASS_OUTPUT)


        return false //None of the annotations were in this round
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return SUPPORTED_ANNOTATIONS.toMutableSet()
    }
}