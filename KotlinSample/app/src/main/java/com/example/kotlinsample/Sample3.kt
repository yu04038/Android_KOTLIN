package com.example.kotlinsample

import com.example.kotlinsample.CarFactory.cars

// Singleton 패턴 적용
// CarFactory 객체를 한번 생성하고 다시는 생성하지 않는다.
// 어디서 사용하든간에 처음 컴파일 될 때 만들어지는 instance 딱 하나이다. 
object CarFactory {
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int): Car {
        val car = Car(horsePower)
        cars.add(car)

        return car
    }
}

data class Car(var horsePower:Int)

fun main() {
    val car1 = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car1)
    println(car2)
    println(cars.size.toString())
}