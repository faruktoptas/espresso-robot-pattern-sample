package com.example.espressorobot

import android.content.Context
import android.support.test.espresso.ViewInteraction

/**
 * Created by ftoptas on 20/12/17.
 */

fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply { func() }

class LoginRobot : BaseTestRobot() {

    fun setEmail(email: String) = fillEditText(R.id.etEmail, email);

    fun setPassword(pass: String) = fillEditText(R.id.etPassword, pass)

    fun clickLogin() = clickButton(R.id.btnLogin)

    fun matchErrorText(err: String) = matchText(textView(android.R.id.message), err)

}