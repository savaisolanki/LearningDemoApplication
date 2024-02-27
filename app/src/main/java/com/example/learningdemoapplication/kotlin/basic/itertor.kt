package com.example.learningdemoapplication.kotlin.basic

fun main() {
    val data = arrayOf(1, 2, 3, 5, 7)

    val list = data.iterator()
    /*

        for (index in list){
            println(index)
        }
    */
    /*

        while (list.hasNext()){
            println(list.next())
        }
    */

    data.forEach {
        println(it)
    }

    for (index in 1..10) {
        if (index == 5) {
            break
        }
        println(index)
    }


    for (index in 1..10) {
        if (index == 5) {
            continue
        }
        println(index)
    }


    for (index in 1..3) {
        println("Outer Loop $index")
        for (indexData in 1..3){
            println("Inner Loop $indexData")
        }
    }

}