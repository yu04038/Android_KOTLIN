import kotlinx.coroutines.*

fun main() = runBlocking {

    launch{ // launch new coroutine in the scope of runBlocking
        myWorld()
    }
    println("Hello,")
}

suspend fun myWorld() {
    delay(1000L)
    println("World!")
}