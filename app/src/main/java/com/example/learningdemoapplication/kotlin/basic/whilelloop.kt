package com.example.learningdemoapplication.kotlin.basic

fun main() {
    var age = 0

    while (age < 10) {
        println(age)
        age++
    }
    var data = 20
    do {
        println("data class")

        data++

        print(data)
    } while (data < 10)
}