package com.example.learningdemoapplication.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BaseApp : Application() {

    /*

        //Manual Code

        var bike = Bike(Wheel(), Sound(), Horn())
        private val factoryClass = FactoryClass
        fun getDataDownload() {
            factoryClass.getDownload()
        }

        //interface via

        val interfaceData = MainModule.mainData

    */

}