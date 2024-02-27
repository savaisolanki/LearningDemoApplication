package com.example.learningdemoapplication.kotlin.basic

import java.util.Scanner

fun main(){

    println("Enter your name:")
    val nameIs= readlnOrNull()
    println(nameIs)

    println("PLease enter age:")
    //val age= readlnOrNull()?.toInt()
    val age= readlnOrNull()
    Integer.parseInt(age)

    println(age)



    //For String
    println("PLease Enter name:")
    val name= readlnOrNull()
    println("your name is $name")

    //scanner class

    val number=Scanner(System.`in`)
    println("Enter a number:")

    val data=number.nextInt()
    println("Enter number is $data")

    val flotData=Scanner(System.`in`)
    println("Enter float number")

    val float=flotData.nextFloat()
    println(float)

    println("Enter float number:")
    val dataBase=Scanner(System.`in`)
    val nameFlot=dataBase.nextFloat()
    println(nameFlot)
}