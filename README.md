# Espresso Robot Pattern Sample

A showcase project for Espresso Robot pattern written in Kotlin.
See the medium post for more details:
[https://medium.com/android-bits/espresso-robot-pattern-in-kotlin-fc820ce250f7](https://medium.com/android-bits/espresso-robot-pattern-in-kotlin-fc820ce250f7)


![!gif](https://user-images.githubusercontent.com/1595227/34454223-e2c3a8e4-ed77-11e7-8452-b79771e68789.gif)

```kotlin
@Test
fun loginMissingEmailPassword() {
    robot
            .clickLogin()
            .matchErrorText(R.string.missing_fields)
}

@Test
fun loginMissingPassword() {
    robot
            .setEmail("mail@example.com")
            .clickLogin()
            .matchErrorText(R.string.missing_fields)
}

@Test
fun loginWrongPassword() {
    robot
            .setEmail("mail@example.com")
            .setPassword("wrong")
            .clickLogin()
            .matchErrorText(R.string.login_fail)
}

@Test
fun loginSuccess() {
    robot
            .setEmail("mail@example.com")
            .setPassword("pass")
            .clickLogin()
            .matchText(R.id.tvName, mActivityTestRule.activity.getString(R.string.name_surname))
}
```

