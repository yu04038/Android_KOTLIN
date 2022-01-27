package com.example.kotlinsample

data class Ticket(val companyName:String, val name:String, var date: String, var seatNumber:Int)

// toString(), hashCode(), equals(), copy() 메소드를 data class 를 이용하면 자동으로 만들어준다.
// POJO

class TicketNormal(val companyName:String, val name:String, var date: String, var seatNumber:Int)



fun main() {
    val ticketA = Ticket("대한항공", "조용진", "2022년 1월 28일", 15)
    val ticketB = TicketNormal("대한항공", "조용진", "2022년 1월 28일", 15)

    // 객체 내용을 확인할 수가 있다.
    println(ticketA)
    // 메모리 주소값
    println(ticketB)
}