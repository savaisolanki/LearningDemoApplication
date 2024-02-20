package com.example.learningdemoapplication.kotlin.flowconcpet

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

fun main() {

    /*
    * filter operator
    * */
    GlobalScope.launch {
        data()
    }


}

/*
* filter operator
* */
suspend fun data() {
    val array = flowOf(2, 3, 5, 6, 7, 8, 9, 11, 14, 17, 18)
    array.filter { it % 2 == 0 }.collect { println(it) }
}