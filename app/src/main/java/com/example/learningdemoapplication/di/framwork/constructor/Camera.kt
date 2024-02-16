package com.example.learningdemoapplication.di.framwork.constructor

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

class Camera @Inject constructor(
    private val cameraPrice: CameraPrice,
    private val cameraColor: CameraColor
) {
    fun getFunctionality() {
        cameraColor.getCameraColor()
        cameraPrice.getCameraPrice()
        Log.i(TAG, "getFunctionality: Camera")
    }
}

class CameraPrice @Inject constructor() {
    fun getCameraPrice() {
        Log.i(TAG, "getFunctionality: 30000")
    }
}

class CameraColor @Inject constructor() {
    fun getCameraColor() {
        Log.i(TAG, "getFunctionality: Black")
    }
}