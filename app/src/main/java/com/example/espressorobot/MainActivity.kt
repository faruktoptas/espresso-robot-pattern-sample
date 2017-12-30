package com.example.espressorobot

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener({ login() })
    }

    private fun login() {
        presenter.login(etEmail.text.toString(), etPassword.text.toString())
    }

    override fun loginSuccess() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }

    override fun loginFail() {
        showError(R.string.login_fail)
    }

    override fun missingFields() {
        showError(R.string.missing_fields)
    }

    private fun showError(msg: Int) {
        val builder = AlertDialog.Builder(this)
        builder
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null)
                .show()
    }
}
