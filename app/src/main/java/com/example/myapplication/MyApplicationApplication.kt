package com.example.myapplication

import android.app.Application
import android.util.Log
import com.example.myapplication.util.SessionManager

class MyApplicationApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: MyApplicationApplication")
        SessionManager.initPreference(this)
    }

    companion object{
        private const val TAG = "MyApplicationApplication"
    }
}