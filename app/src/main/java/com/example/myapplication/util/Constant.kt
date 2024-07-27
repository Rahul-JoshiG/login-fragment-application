package com.example.myapplication.util

object Constant {
    interface App  {
        companion object {
            const val PREFERENCE_NAME = "Log In Preference"
        }
    }

    interface Keys  {
        companion object {
            const val EMAIL_KEY = "email_key"
            const val PASSWORD_KEY = "password_key"
            const val EMAIL_KEY_IN_FRAGMENT = "email_key_in_fragment"
            const val IS_LOGGED_IN = "IS_LOGGED_IN"
        }
    }
}
