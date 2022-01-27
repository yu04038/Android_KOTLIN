package com.example.kotlinsample

fun main() {
    helloWorld()
    println(add(4,5))

    // 3. String template
    val name = "yong jin"
    println("my name is $name")

    // 띄어쓰기를 하기 싫다면 대괄호로 변수 범위 설정이 가능하다.
    println("my name is ${name}I'm 25")

    checkNumber(1)

}

// 1. 함수
// 리턴형이 없다면 Unit, 생략해도 된다.
fun helloWorld() : Unit{
    println("Hello World!")
}

// 리턴형이 있다면 리턴 타입을 반드시 지정해주어야 한다.
fun add(a: Int, b: Int): Int {
    return a + b
}

// 2. val vs var
// val = value (바뀌지 않는 것!)

fun hi() {
    val a: Int = 10
    var b: Int = 9
    b = 100

    // 이렇게 해도 타입 추론 가능
    val c = 100
    val d = "yong jin"
}

// 4. 조건식
fun maxBy(a: Int, b: Int) :Int {

    return if (a > b) {
        a
    } else {
        b
    }
}

fun maxBy2(a: Int, b: Int) = if (a>b) a else b

fun checkNumber(score: Int) {
    //switch 역할!
    when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        // 복수 정답 인정 가능
        2,3 -> println("this is 2 or 3")
        // 아무것도 아닐 때!
        else -> println("I don't know")
    }

    var b = when(score) {
        1 -> 1
        2 -> 2
        // 반드시 else 를 써줘야 한다!
        else -> 3
    }

    println("b : $b")

    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("Not Bad")
        else -> println("Ok")
    }
}