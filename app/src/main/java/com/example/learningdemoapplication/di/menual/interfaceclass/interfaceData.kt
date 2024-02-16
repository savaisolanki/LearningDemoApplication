package com.example.learningdemoapplication.di.menual.interfaceclass

import android.content.ContentValues.TAG
import android.util.Log

interface InterfaceData {
    fun data()
}

class Implementation : InterfaceData {
    override fun data() {
        Log.i(TAG, "data: Data Interface Provided")
    }
}

class InterfaceDataLoad(private val implementation: Implementation) {
    fun mainData() {
        implementation.data()
    }
}


object MainModule {
    val mainData = InterfaceDataLoad(Implementation())
}