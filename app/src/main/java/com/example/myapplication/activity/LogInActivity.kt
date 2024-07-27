package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.util.Constant
import com.example.myapplication.util.SessionManager
import com.example.myapplication.util.ToastHelper

class LogInActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    private var mEmailString: String = ""
    private var mPasswordString: String = ""
    private val mBundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setContentView(mBinding.root)

        extractDataFromFields()
        rememberMe()

        mBinding.loginBtn.setOnClickListener {
            checkValidateData()
        }
    }

    private fun rememberMe() {
        Log.d(TAG, "rememberMe: ")
        mBinding.rememberMe.setOnCheckedChangeListener { _, _ ->
            SessionManager.putBoolean(Constant.Keys.IS_LOGGED_IN, true)
            SessionManager.putString(Constant.Keys.EMAIL_KEY, mEmailString)
        }
    }

    private fun extractDataFromFields() {
        Log.d(TAG, "extractDataFromFields: ")

        mBinding.emailTextView.addTextChangedListener {
            Log.d(TAG, "extractDataFromFields: getting email")
            mEmailString = it.toString().trim()
        }

        mBinding.passwordTextView.addTextChangedListener {
            Log.d(TAG, "extractDataFromFields: getting password")
            mPasswordString = it.toString().trim()
        }
    }

    private fun checkValidateData() {
        Log.d(TAG, "checkValidateData: ")
        if (mEmailString.isEmpty() || mPasswordString.isEmpty()) {
            ToastHelper.showToast(this, "Please fill all details...")
            return
        }

        if (mEmailString == "rahul123@gmail.com" && mPasswordString == "1234") {
            navigateToDashBoardActivity()
            resetDataFields()
            return
        } else {
            ToastHelper.showToast(this, "email password mismatch")
        }
    }

    private fun resetDataFields() {
        mBinding.emailTextView.setText(R.string.empty_string)
        mBinding.passwordTextView.setText(R.string.empty_string)
    }

    private fun navigateToDashBoardActivity() {
        val intent = Intent(this, DashBoardActivity::class.java)
        mBundle.putString(Constant.Keys.EMAIL_KEY, mEmailString)
        mBundle.putString(Constant.Keys.PASSWORD_KEY, mPasswordString)
        intent.putExtras(mBundle)
        startActivity(intent)
    }

    companion object {
        private const val TAG = "LogInActivity"
    }
}
