package com.example.learningdemoapplication.kotlin.basic

import java.util.ArrayList

fun main(){
    val intArray= mutableListOf<Int>(1,2,3,5,7,8,9,10)
    val bekiNumber= ArrayList<Int>()


    intArray.forEach {
       if (it % 2 == 0) bekiNumber.add(it)
    }

    bekiNumber.forEach {
        println(it)
    }



}