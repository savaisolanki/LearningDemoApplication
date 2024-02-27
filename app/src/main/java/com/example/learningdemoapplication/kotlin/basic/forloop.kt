package com.example.learningdemoapplication.kotlin.basic

import androidx.core.util.rangeTo

fun main(){
    for (index in 1..10 step 2){
        println(index)
    }

    for (index in 10 downTo 1 step 2){
        println(index)
    }
    for (index in 1.rangeTo(6)){
        println(index)
    }

    for (index in 10.downTo(5)){
        println(index)
    }

}