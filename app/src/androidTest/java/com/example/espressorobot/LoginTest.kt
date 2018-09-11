package com.example.espressorobot


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.jraska.falcon.FalconSpoonRule


@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {


    @get:Rule
    val mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val falconSpoonRule = FalconSpoonRule()


    @Test
    fun loginMissingEmailPassword() {
        login {
            clickLogin()
            screenShot(falconSpoonRule, "loginMissingEmailPassword")
            matchErrorText(string(R.string.missing_fields))
        }
    }

    @Test
    fun loginMissingPassword() {
        login {
            setEmail("mail@example.com")
            clickLogin()
            screenShot(falconSpoonRule, "loginMissingPassword")
            matchErrorText(string(R.string.missing_fields))
        }
    }

    @Test
    fun loginWrongPassword() {
        login {
            setEmail("mail@example.com")
            setPassword("wrong")
            clickLogin()
            screenShot(falconSpoonRule, "loginWrongPassword")
            matchErrorText(string(R.string.login_fail))
        }

    }

    @Test
    fun loginSuccess() {
        login {
            setEmail("mail@example.com")
            setPassword("pass")
            clickLogin()
            screenShot(falconSpoonRule, "loginSuccess")
            matchText(R.id.tvName, string(R.string.name_surname))
        }
    }

    @Test
    fun loginProfileAndSettings() {
        login {
            setEmail("mail@example.com")
            setPassword("pass")
            screenShot(falconSpoonRule, "login")
            clickLogin()
            screenShot(falconSpoonRule,"profile")
        }
        profile {
            clickSettings()
            screenShot(falconSpoonRule,"settings")
            toggleNotifications()
            screenShot(falconSpoonRule,"toggle1")
            toggleNightMode()
            screenShot(falconSpoonRule,"toggle2")
        }
    }

    private fun string(res: Int): String = mActivityTestRule.activity.getString(res)
}
