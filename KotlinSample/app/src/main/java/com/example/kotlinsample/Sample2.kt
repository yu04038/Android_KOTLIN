package com.example.kotlinsample

// 1. lambda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄 수가 있다. fun maxBy(a: Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본 정의
// val lambdaName : Type = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number -> number * number}
val nameAge = {name:String, age: Int ->
    "my name is $name, my age is $age"
}


fun main() {
    println(square(12))
    println(nameAge("yong jin", 26))
    var a = "yong jin said, "
    var b = "mac said, "

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana", 28))
    println(calculateGrade(98))

    val lambda = {number: Double ->
        number == 4.323
    }
    println(invokeLambda(lambda))
}

// 확장 함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString (name:String, age:Int): String {
    val introduceMyself: String.(Int) -> String = {
        "I am $this and $it years old"
    }
    return name.introduceMyself(age)
}

// 람다의 Return

val calculateGrade: (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법
fun invokeLambda(lambda : (Double) -> Boolean): Boolean {
    return lambda(5.234)
}