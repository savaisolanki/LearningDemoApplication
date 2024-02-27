package com.example.learningdemoapplication.kotlin.basic

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
    println(array[0])
    array[0] = 10
    println(array[0])

    val intArray = intArrayOf(1, 2, 4, 5, 6)
    println(intArray[4])
    println(intArray.size)

    intArray[4] = 30
    println(intArray[4])

    //nul type array
    var arrayList = arrayOfNulls<Int>(5)

    arrayList[0] = 1
    arrayList[1] = 10
    arrayList[2] = 2
    arrayList[3] = 3

    println("previous empty")

    println(arrayList.get(1))


    arrayList= emptyArray()
    println("after empty")
    println(arrayList)

    val nameArray=Array<Int>(6){
        it
    }

    println(nameArray[1])


    val flotArray=IntArray(5){
        it * 2
    }



}