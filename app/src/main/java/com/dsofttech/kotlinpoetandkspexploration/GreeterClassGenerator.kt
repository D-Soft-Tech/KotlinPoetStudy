package com.dsofttech.kotlinpoetandkspexploration

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

private val greeterClass = ClassName("", "Greeter")
val file = FileSpec.builder("", "MyFirstGeneratedFile")
    .addType(
        TypeSpec.classBuilder("Greeter")
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .addParameter("nameOfWhoToGreet", String::class)
                    .build(),
            )
            .addProperty(
                PropertySpec.builder("nameOfWhoToGreet", String::class)
                    .initializer("nameOfWhoToGreet")
                    .build(),
            )
            .addFunction(
                FunSpec.builder("performGreetings")
                    .addStatement("println(%P)", "Hello, \$nameOfWhoToGreet")
                    .build(),
            ).build(),
    ).addFunction(
        FunSpec.builder("main")
            .addParameter("args", String::class, KModifier.VARARG)
            .addStatement("%T(args[0]).greet()", greeterClass)
            .build(),
    ).build()

val mainFunction = FunSpec.builder("main")
    .addCode(
        """
        val total = 0 
        for (i in 0 until 10) {
            ++total
        }
        """.trimMargin(),
    )
    .build()
