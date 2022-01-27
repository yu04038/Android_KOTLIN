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

    forAndWhile()

    nullCheck()

    ignoreNulls("hi")
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

// 5. Array, List
// Array : 기본적으로 정해져 있는 사이즈 있다. 메모리가 할당이 되어 나오므로 미리 지정해줘야 한다. mutable
// List : MutableList vs ImmutableList

fun array() {
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    val array2 = arrayOf(1, "d", 0.2)

    array[0] = 3
    var result = list[0]

    // val로 쓸수 있는데, 이는 arrayList의 참조값이 변하지 않기 때문이다.
    var arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
}

// 6. for / while

fun forAndWhile() {

    val students = arrayListOf("철수", "영희", "용진", "훈발놈")

    for (name in students) {
        println("$name")
    }

    for ((index, name) in students.withIndex()) {
        println("${index+1} 번째 학생 : $name")
    }

    var sum = 0
    // downTo, step, until
    // 1..100 과 1 until 100의 차이점은, 100을 포함하고 안하고의 차이이다.
    for ( i in 1..10 step 2) {
        sum += i
    }
    println(sum)

    var index = 0
    while(index < 10) {
        println("current index = $index")
        index++
    }
}

// 7. Nullable, NonNull
fun nullCheck() {
    // NPE : Null Pointer Exception
    // compile 에서 오류를 알려줌으로써 runtime 에서 생기는 오류를 막을 수가 있다.

    var name : String = "yong jin" // null 이면 안되는 타입!

    var nullName : String? = null // error 안뜸

    var nameInUpperCase = name.toUpperCase()

    // nullName Nonnull -> Uppercase
    // nullName null -> null
    var nullNameInUpperCase = nullName?.toUpperCase()

    // ?:
    // lastName 이 null 일 경우 default 값 제시
    val lastName : String? = null

    val fullName = name + " " + (lastName?: "No lastName")
    println(fullName)


}

// !!
fun ignoreNulls(str: String?) {
    // 컴파일러에게 절대 null 일리가 없으므로 null 아니라고 생각하라는 뜻
    var notNull : String = str!!
    var upper = notNull.toUpperCase()

    val email :String? = "yu04038@gmail.com"

    // email null 이 아니라면? let 실행
    email?.let{
        println("email is $it")
    }
}