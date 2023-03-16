package com.dsofttech.kotlinpoetandkspexploration.strings

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec

/*
%S is used for string literals, i.e you want to have sting that will enclosed with quotation marks
while %P is used for string templating, i.e you want to pass a variable in between a string
* */

/**
This makes use of string literals %S
@param name
 * */
private fun whatIsMyName(name: String): FunSpec {
    return FunSpec.builder(name)
        .returns(String::class)
        .addStatement("return My name is %S", name)
        .build()
}

private val helloWorldClass = TypeSpec.classBuilder("HelloWorld")
    .addFunction(whatIsMyName("Adebayo"))
    .addFunction(whatIsMyName("Oluwapelumi"))
    .addFunction(whatIsMyName("Mobolawale"))
    .build()

val kotlinPoetStringManipulationFile = FileSpec.builder(
    "com.dsofttech.kotlinpoetandkspexploration.generatedFiles",
    "KotlinPoetStringManipulation",
)
    .addType(helloWorldClass)
    .build()

// STRING TEMPLATING STARTS HERE
val amount = 50
val stringWithDollarSymbol = "Your total is " + "$" + "amount"
val funSpec = FunSpec.builder("printTotal")
    .returns(String::class)
    .addStatement("return %P", stringWithDollarSymbol)
    .build()

val stringTemplatingClass = TypeSpec.classBuilder("StringTemplatingFile")
    .addFunction(funSpec)
    .build()

val stringTemplatingFile = FileSpec.builder("", "StringTemplatingClass")
    .addType(stringTemplatingClass)
    .build()
