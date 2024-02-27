package com.example.learningdemoapplication.kotlin.basic

fun main(){
    //var ->its mutable

    var name="savai"
    println(name)

    name = "Deb"
    println(name)

    //val -> its not changeable

    val dev:String="dev"
    println(dev)
   // dev="sabai"  this is giving error when u should reassign value


    println(dev)
    println("the value is $dev")
    println("database is name " + dev)
    println("one name is $name and second name $dev so total name is ${name+dev}")
}