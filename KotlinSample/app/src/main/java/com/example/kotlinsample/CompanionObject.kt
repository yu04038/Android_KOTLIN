package com.example.kotlinsample

class Book private constructor(val id: Int, val name: String) {

    // private property 나 메소드를 읽어올 수 있게 끔 해준다.
    // static method, static property
    companion object BookFactory : IdProvider{

        val myBook = "new Book"

        fun create() = Book(0, "animal farm")

        fun createB() = Book(getId(), myBook)

        override fun getId(): Int {
            return 444
        }
    }
}

interface IdProvider {
    fun getId() : Int
}

fun main() {
    val book = Book.create()
    val bookB = Book.createB()

    println("${book.id}, ${book.name}")
    println("${bookB.id}, ${bookB.name}")
}