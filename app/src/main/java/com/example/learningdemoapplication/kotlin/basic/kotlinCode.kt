package com.example.learningdemoapplication.kotlin.basic

fun main(){
    println("Hello Kotlin")

    val myValue = 30
    val myValue2 = 20

    println(myValue)
    println(myValue2)

    println(Int.MAX_VALUE)
    println(Int.MIN_VALUE)

    println(Byte.MAX_VALUE)
    println(Byte.MIN_VALUE)

    println(Short.MAX_VALUE)
    println(Short.MIN_VALUE)

    println(Long.MAX_VALUE)
    println(Long.MIN_VALUE)

    println(Double.MAX_VALUE)
    println(Double.MIN_VALUE)

    println(Float.MAX_VALUE)
    println(Float.MIN_VALUE)

    var name: String = "Savai"
    println(name)
    name = "Dev"
    println(name)


    //Operator

    //1.Arithmetic Op

    var a = 20
    val b = 50

    println(a + b)
    println(a - b)
    println(a * b)
    println(a / b)
    println(a % b)

    //2.Relational OP

    val result = if (a > b) "a is greater " else "b is greter"
    println(result)
    val result1 = if (a < b) "a is less " else "b is less"
    println(result1)
    val result2 = if (a == b) "a and b is same " else "not same"
    println(result2)
    val result3 = if (a >= b) "a is greater " else "b is greter"
    println(result3)

    //3.Assignment op
    a = a + b
    println(a)
    a -= b
    println(a)

    //4.Increment and Decrement OP

    var age=40
    println(age)
    age++
    println(age)
    println(age)
    println(age++)
    println(age)  //42

    println(++age)  //43
    println(age) //43

    println(++age) //44
    println(age) //44

    println(--age) //43
    println(age) //43

    println(--age) //42
    println(age) //42

    println(age--)  //42
    println(age) //41

    println(age--) //41
    println(age) //40


   // println(  age + age-- + --age + age + age++  + ++age + age )

    //println(age  +  --age  +  age  +  --age  +  age  +  ++age  +  age  +  age--  +  age +  age++  +  age )
    println(age)   //40
    println(--age)  //39
    println(age)  //39
    println(--age) //38
    println(age) //38
    println(++age) //39
    println(age) //39
    println(age--) //39
    println(age) //38
    println(age++) //38
    println(age) //39
    println(++age) //40
    println(age) //40
    println(--age) //39
    println(age) //39
    println(age++) //39
    println(age) //40
    println(++age) //41
    println(age) //41

    //4.logical op

    val ageData=20
    val ageData1=21
    val ageData2=22

    val ageResult=if (ageData2>ageData1 && ageData2>ageData) {
        "true"
    }else "false"
    println(ageResult)

    val ageResult1=if (ageData2<ageData1 || ageData2>ageData) {
        "true"
    }else "false"
    println(ageResult1)

    val ageResult2=if (ageData2<ageData1 || ageData2<ageData) {
        "true"
    }else "false"
    println(ageResult2)

    val ageResult3=if ( !(ageData2 == ageData1) ) {
        "true"
    }else "false"
    println(ageResult3)

}