package com.example.myapplication.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SessionManager {

    private const val TAG = "SessionManager"
    private lateinit var sharedPreferences: SharedPreferences

    fun initPreference(context: Context) {
        Log.d(TAG, "initPreference: context $context")
        sharedPreferences =
            context.getSharedPreferences(Constant.App.PREFERENCE_NAME, Context.MODE_PRIVATE)

    }

    fun putString(key: String, value: String) {
        Log.d(TAG, "putString: key $key = value $value")
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        Log.d(TAG, "getString: key $key")
        return sharedPreferences.getString(key, null)
    }

    fun putBoolean(key: String, value: Boolean) {
        Log.d(TAG, "putBoolean: key $key = value $value")
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }

}