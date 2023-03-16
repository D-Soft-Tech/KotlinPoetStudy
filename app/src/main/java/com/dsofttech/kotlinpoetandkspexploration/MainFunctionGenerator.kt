package com.dsofttech.kotlinpoetandkspexploration

import com.squareup.kotlinpoet.FunSpec

// The First way to create a function using FunSpec and .addCode(/*code block here*/)
// This method takes in the whole code body, i.e what should be in the code body as multi-line string
// Pass the name of the function as parameter to the .builder(/*name of the function here*/) method of the FunSpec class used for creating the function
val mainFunctionBuilder = FunSpec.builder("main")
    .addCode(
        """
            val total = 0
            for (i in 0 until 10) {
                ++total
            }
        """.trimMargin(),
    ).build()

// Another way is to use the additional APIs which assist with newlines, braces and indentation
val mainFunction2 = FunSpec.builder("main")
    .addStatement("val total = 0")
    .beginControlFlow("for (i in 0 until 10)")
    .addStatement("++total")
    .endControlFlow()
    .build()

// Another way, which helps to add arguments or pass parameters to the function instead of hardcoding parameters
// here we have a normal function into which we will pass the parameters to and then return a FunSpec which utilizes the parameter from it
// The created function also returns a value, this is made possible by using the .returns(/*return type here*/) api
private fun createMainFunction(
    nameOfTheFunction: String,
    from: Int,
    to: Int,
    operation: String,
): FunSpec {
    return FunSpec.builder(nameOfTheFunction)
        .returns(Int::class)
        .addStatement("val result = if($from == `+`) 0 else 1")
        .beginControlFlow("for (i in $from until $to)")
        .addStatement("result = result $operation i")
        .endControlFlow()
        .addStatement("return result")
        .build()
}
