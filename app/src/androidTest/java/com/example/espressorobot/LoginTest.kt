package com.example.espressorobot


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {


    @get:Rule
    val mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun loginMissingEmailPassword() {
        login {
            clickLogin()
            screenShot("loginMissingEmailPassword")
            matchErrorText(string(R.string.missing_fields))
        }
    }

    @Test
    fun loginMissingPassword() {
        login {
            setEmail("mail@example.com")
            clickLogin()
            screenShot("loginMissingPassword")
            matchErrorText(string(R.string.missing_fields))
        }
    }

    @Test
    fun loginWrongPassword() {
        login {
            setEmail("mail@example.com")
            setPassword("wrong")
            clickLogin()
            screenShot("loginWrongPassword")
            matchErrorText(string(R.string.login_fail))
        }

    }

    @Test
    fun loginSuccess() {
        login {
            setEmail("mail@example.com")
            setPassword("pass")
            clickLogin()
            screenShot("loginSuccess")
            matchText(R.id.tvName, string(R.string.name_surname))
        }
    }

    @Test
    fun loginProfileAndSettings() {
        login {
            setEmail("mail@example.com")
            setPassword("pass")
            screenShot("login")
            clickLogin()
            screenShot("profile")
        }
        profile {
            clickSettings()
            screenShot("settings")
            toggleNotifications()
            screenShot("toggle1")
            toggleNightMode()
            screenShot("toggle2")
        }
    }

    private fun string(res: Int): String = mActivityTestRule.activity.getString(res)
}
