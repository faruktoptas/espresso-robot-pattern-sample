# Espresso Robot Pattern Sample with Spoon Integration

A showcase project for Espresso Robot pattern written in Kotlin.
See the medium posts for more details:

* [Espresso Robot Pattern in Kotlin](https://medium.com/android-bits/espresso-robot-pattern-in-kotlin-fc820ce250f7)
* [Running Espresso Tests on Multiple Devices with Spoon](https://medium.com/android-bits/running-espresso-tests-on-multiple-devices-with-spoon-842a5546e3d7)


![!gif](https://user-images.githubusercontent.com/1595227/34454223-e2c3a8e4-ed77-11e7-8452-b79771e68789.gif)

```kotlin
@Test
fun loginMissingEmailPassword() {
    login {
        clickLogin()
        matchErrorText(string(R.string.missing_fields))
    }
}

@Test
fun loginMissingPassword() {
    login {
        setEmail("mail@example.com")
        clickLogin()
        matchErrorText(string(R.string.missing_fields))
    }
}

@Test
fun loginWrongPassword() {
    login {
        setEmail("mail@example.com")
        setPassword("wrong")
        clickLogin()
        matchErrorText(string(R.string.login_fail))
    }

}

@Test
fun loginSuccess() {
    login {
        setEmail("mail@example.com")
        setPassword("pass")
        clickLogin()
        matchText(R.id.tvName, string(R.string.name_surname))
    }
}

@Test
fun loginProfileAndSettings() {
    login {
        setEmail("mail@example.com")
        setPassword("pass")
        clickLogin()
    }
    profile {
        clickSettings()
        toggleNotifications()
        toggleNightMode()
    }
}
```

