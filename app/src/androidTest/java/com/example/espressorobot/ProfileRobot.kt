package com.example.espressorobot


fun profile(func: ProfileRobot.() -> Unit) = ProfileRobot().apply { func() }

class ProfileRobot : BaseTestRobot() {

    fun clickSettings() = clickButton(R.id.btnSettings)

    fun toggleNotifications() = clickListItem(android.R.id.list, 0)

    fun toggleNightMode() = clickListItem(android.R.id.list, 1)

}