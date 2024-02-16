package com.example.learningdemoapplication.di.menual.constructor

import android.content.ContentValues.TAG
import android.util.Log


class Https {
}

class Executor {
}

class Request constructor(private val https: Https, private val executor: Executor) {
    fun getRequest() {
        Log.i(TAG, "getRequest: Request For Downloading......")
    }
}

class Downloader(private val request: Request) {
    fun download() {
        request.getRequest()
        Log.i(TAG, "download: File Downloading")
    }
}

object FactoryClass {
    private val https = Https()
    private val executor = Executor()
    private val request = Request(https, executor)
    private val downloader= Downloader(request)

    fun getDownload(): Downloader {
        downloader.download()
        return Downloader(request)
    }

}