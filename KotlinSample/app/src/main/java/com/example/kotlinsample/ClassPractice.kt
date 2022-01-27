package com.example.kotlinsample

// 기본 생성자, default 값을 줄 수 있다.
// open 을 통해서 상속을 받을 수 있게 해준다.
open class Human(val name: String = "Anonymous"){

    // 항상 부 생성자는 주 생성자의 위임을 받아야 한다. 주 생성자가 없다면 위임받을 필요가 없다.
    constructor(name:String, age:Int) : this(name) {
        println("My name is $name, $age years old")
    }
    // 주 생성자 - 처음 인스턴스를 생성할 때 어떤 동작을 할지를 적어줄 수 있다. 가장 먼저 생성됨!
    init {
        println("New Human has been born!")
    }

    fun eatingCake() {
        println("This is so yummy")
    }

    open fun singASong() {
        println("lalala")
    }
}

class Korean : Human() {
    override fun singASong() {
        println("라라라")
        println("My name is : $name")
    }
}

fun main() {
    // new 를 사용할 필요 없다.
    val human = Human("yong jin")

    val stranger = Human()
    human.eatingCake()

    val mom = Human("jeong hwa", 55)

    println("this human's name is ${human.name}")
    println("this human is ${stranger.name}")

    val korean = Korean()
    korean.singASong()
}