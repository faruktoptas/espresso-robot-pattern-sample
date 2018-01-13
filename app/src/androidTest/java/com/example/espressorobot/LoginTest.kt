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
    fun loginMissingEmailPassword() {
        robot
                .clickLogin()
                .screenShot("loginMissingEmailPassword")
                .matchErrorText(R.string.missing_fields)
    }

    @Test
    fun loginMissingPassword() {
        robot
                .setEmail("mail@example.com")
                .clickLogin()
                .screenShot("loginMissingPassword")
                .matchErrorText(R.string.missing_fields)
    }

    @Test
    fun loginWrongPassword() {
        robot
                .setEmail("mail@example.com")
                .setPassword("wrong")
                .clickLogin()
                .screenShot("loginWrongPassword")
                .matchErrorText(R.string.login_fail)
    }

    @Test
    fun loginSuccess() {
        robot
                .setEmail("mail@example.com")
                .setPassword("pass")
                .clickLogin()
                .screenShot("loginSuccess")
                .matchText(R.id.tvName, mActivityTestRule.activity.getString(R.string.name_surname))
    }

    @Test
    fun loginProfileAndSettings() {
        robot
                .setEmail("mail@example.com")
                .setPassword("pass")
                .screenShot("login")
                .clickLogin()
                .screenShot("profile")
                .clickSettings()
                .screenShot("settings")
                .toggleNotifications()
                .screenShot("toggle1")
                .toggleNightMode()
                .screenShot("toggle2")
    }
}
