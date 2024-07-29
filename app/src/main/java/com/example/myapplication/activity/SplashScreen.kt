package com.example.myapplication.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.util.Constant
import com.example.myapplication.util.SessionManager

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        checkedIsLoggedIn()
    }

    private fun checkedIsLoggedIn() {
        val isLoggedIn = SessionManager.getBoolean(Constant.Keys.IS_LOGGED_IN)
        Log.d(TAG, "checkedIsLoggedIn: isLoggedIn $isLoggedIn")
        if (isLoggedIn) {
            openActivity(DashBoardActivity::class.java)
        } else {
            openActivity(LogInActivity::class.java)
        }
    }

    private fun openActivity(activity: Class<*>) {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, activity)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_TIME)
    }

    companion object {
        private const val SPLASH_SCREEN_TIME: Long = 3000
        private const val TAG = "SplashScreen"
    }
}
