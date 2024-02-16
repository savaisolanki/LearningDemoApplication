package com.example.learningdemoapplication.di.menual.constructor

import android.content.ContentValues.TAG
import android.util.Log

class Bike(private var wheel: Wheel, private var sound: Sound, private val horn: Horn) {

    fun getBikeInfo() {
        wheel.getWheel()
        sound.getSound()
        horn.getHorn()
    }
}

class Wheel {
    fun getWheel() {
        Log.i(TAG, "getWheel:Total 2 Wheel")
    }

}

class Sound {

    fun getSound() {
        Log.i(TAG, "Bhum Bhum Bhum")
    }
}

class Horn {
    fun getHorn() {
        Log.i(TAG, "Tii Tii Tii")
    }
}
