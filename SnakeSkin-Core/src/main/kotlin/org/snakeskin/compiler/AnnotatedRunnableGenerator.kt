package org.snakeskin.compiler

import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.*
import javax.tools.Diagnostic

class AnnotatedRunnableGenerator(val env: ProcessingEnvironment, val annotationName: String) {
    companion object {
        const val RUN_METHOD = "run"
        const val GET_NAME_METHOD = "getName"

        fun getMethodQualifiedName(method: ExecutableElement): String {
            val type = method.enclosingElement as TypeElement
            return "${type.qualifiedName}.${method.simpleName}"
        }
    }

    private fun getWrapperClassName(typeName: String, method: ExecutableElement): String {
        val name = method.simpleName.toString()
        val capitalized = Character.toUpperCase(name.first()) + name.substring(1)
        return typeName + capitalized + "Wrapper"
    }

    private fun getWrapperClassName(method: ExecutableElement): String {
        val type = method.enclosingElement as TypeElement
        return getWrapperClassName(type.qualifiedName.toString(), method)
    }

    private fun getWrapperSimpleName(method: ExecutableElement): String {
        val type = method.enclosingElement as TypeElement
        return getWrapperClassName(type.simpleName.toString(), method)
    }

    private fun getPackageName(element: Element): String? {
        var e: Element? = element
        while (e != null) {
            if (e.kind == ElementKind.PACKAGE) {
                return (e as PackageElement).qualifiedName.toString()
            }

            e = e.enclosingElement
        }
        return null
    }

    fun generate(method: ExecutableElement): String {
        val className = getWrapperClassName(method)
        val simpleName = getWrapperSimpleName(method)
        val methodQualifiedName = getMethodQualifiedName(method)
        val packageName = getPackageName(method)

        val runMethodSpec = MethodSpec.methodBuilder(RUN_METHOD)
                .addModifiers(Modifier.PUBLIC)
                .returns(Void.TYPE)
                .addStatement("\$L()", methodQualifiedName)
                .build()

        val getNameMethodSpec = MethodSpec.methodBuilder(GET_NAME_METHOD)
                .addModifiers(Modifier.PUBLIC)
                .returns(String::class.java)
                .addStatement("return \$S", annotationName)
                .build()

        val classSpec = TypeSpec.classBuilder(simpleName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addSuperinterface(AnnotatedRunnable::class.java)
                .addMethod(runMethodSpec)
                .addMethod(getNameMethodSpec)
                .build()

        val javaFile = JavaFile.builder(packageName ?: "", classSpec).build()
        javaFile.writeTo(env.filer)
        return className
    }
}