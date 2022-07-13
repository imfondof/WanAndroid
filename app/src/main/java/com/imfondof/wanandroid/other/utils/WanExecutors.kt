package com.imfondof.wanandroid.other.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object WanExecutors {
    val diskIO = Executors.newSingleThreadExecutor()
    val networkIO = Executors.newFixedThreadPool(3)
    val mainThread = MainThreadExecutor()

    class MainThreadExecutor : Executor {
        private val handler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable?) {
            command?.let { handler.post(it) }
        }
    }
}