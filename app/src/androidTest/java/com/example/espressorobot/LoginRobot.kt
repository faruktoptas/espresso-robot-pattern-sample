package com.example.espressorobot

import android.content.Context
import android.support.test.espresso.ViewInteraction

/**
 * Created by ftoptas on 20/12/17.
 */

class LoginRobot(private val context: Context) : BaseTestRobot() {

    fun setEmail(email: String) = apply { fillEditText(R.id.etEmail, email); }

    fun setPassword(pass: String) = apply { fillEditText(R.id.etPassword, pass) }

    fun clickLogin() = apply {
        clickButton(R.id.btnLogin)
    }

    fun clickSettings() = apply { clickButton(R.id.btnSettings) }

    fun matchErrorText(err: Int): ViewInteraction {
        return matchText(textView(android.R.id.message), context.getString(err))
    }

    fun toggleNotifications() = apply {
        clickListItem(android.R.id.list, 0)
    }

    fun toggleNightMode() = apply {
        clickListItem(android.R.id.list, 1)
    }
    fun sleep()=apply {
        Thread.sleep(500)
    }

}