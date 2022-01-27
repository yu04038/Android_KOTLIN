package com.example.kotlinsample

fun main() {
    helloWorld()
    println(add(4,5))

    // 3. String template
    val name = "yong jin"
    println("my name is $name")

    // 띄어쓰기를 하기 싫다면 대괄호로 변수 범위 설정이 가능하다.
    println("my name is ${name}I'm 25")

    

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