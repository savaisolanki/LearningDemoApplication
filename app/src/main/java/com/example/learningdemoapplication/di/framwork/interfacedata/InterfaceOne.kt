package com.example.learningdemoapplication.di.framwork.interfacedata

import android.content.ContentValues.TAG
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface InterfaceOne {
    fun interfaceDataOne()
}

class InterfaceOneImplementation @Inject constructor() : InterfaceOne {
    override fun interfaceDataOne() {
        Log.i(TAG, "interfaceDataOne: InterfaceOne Impelemntation Mian Hellpo")
    }
}

class InterfaceOneMain @Inject constructor(private val interfaceOne: InterfaceOne) {

    fun mainData() {
        interfaceOne.interfaceDataOne()
    }

}

// Using Binds Methods for interface Implementation
/*

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceOneImplementationModule {
    @Binds
    @Singleton
    abstract fun result(interfaceOneImplementation: InterfaceOneImplementation): InterfaceOne
}

*/


// Using Provides Methods for interface Implementation

@Module
@InstallIn(SingletonComponent::class)
object ModuleApp {

    @Provides
    @Singleton

    fun result(): InterfaceOne = InterfaceOneImplementation()
}

