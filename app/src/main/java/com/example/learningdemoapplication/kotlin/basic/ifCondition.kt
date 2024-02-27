package com.example.learningdemoapplication.kotlin.basic

fun main(){
    val a=10
    val b= 50
    val c=500

    val result=if (a>b) a else b
    println(result)

    val data= if (a>b) a else if (b>c) b else c
    println(data)
}