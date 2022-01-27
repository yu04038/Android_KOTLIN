package com.example.kotlinsample

class Book private constructor(val id: Int, val name: String) {

    companion object {
        fun create() = Book(0, "animal farm")
    }
}

fun main() {}