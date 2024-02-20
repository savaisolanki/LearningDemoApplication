package com.example.learningdemoapplication.kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/*fun main() {
    GlobalScope.launch {
        data1()
        data2()
    }


}*/

fun main() = runBlocking {
    val flow = flow {
        emit(1)
        emit(2)
        throw RuntimeException("Error occurred")
        emit(3)
    }

    flow.retry(1) { cause ->
        println("Retrying due to: $cause")
        delay(100)
        true
    }.catch { cause ->
        println("Flow collection failed: $cause")
    }.collect { value ->
        println("Received: $value")
    }


    val numbers = (1..5).asFlow()
    val strings = flowOf("one", "two", "three", "four", "five")

    val numbers1 = (1..5).asFlow()
    val strings1 = flowOf("one", "two", "three", "four", "five")


    val combine = numbers.zip(strings) { numbers, string ->
        "$numbers->$string"
    }.zip(numbers1.zip(strings1) { numbers1, string1 ->
        "$numbers1->$string1"
    }) { firstPair, secondPair ->
        "$firstPair, $secondPair"
    }

    combine.collect { combine ->
        println(combine)
    }
    strings.zip(numbers) { number, string ->
        "$number -> $string"
    }.collect { combined ->
        println(combined)
    }


}

suspend fun data1() {
    print("data1: Data1 started")
    delay(100)
    print("data1: Data1 ended")

}

suspend fun data2() {
    print("data2: Data2 started")
    delay(200)
    print("data2: Data2 ended")

}