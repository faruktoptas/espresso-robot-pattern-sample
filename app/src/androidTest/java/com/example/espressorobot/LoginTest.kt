package com.example.espressorobot


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {


    @get:Rule
    val mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private lateinit var robot: LoginRobot

    @Before
    fun setup() {
        robot = LoginRobot(mActivityTestRule.activity)
    }

    @Test
    fun loginWrongPassword() {
        robot
                .sleep()
                .setEmail("mail@example.com")
                .sleep()
                .setPassword("wrong")
                .sleep()
                .clickLogin()
                .sleep()
                .matchErrorText(R.string.login_fail)
    }
}
