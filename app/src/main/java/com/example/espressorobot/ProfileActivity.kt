package com.example.espressorobot

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_profile.*

/**
 * Created by ftoptas on 20/12/17.
 */
class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnSettings.setOnClickListener { startActivity(Intent(this, SettingsActivity::class.java)) }

        intent.data?.let {
            Log.i("asd", "host: " + it.host)
            Log.i("asd", "q: " + it.query)
            it.queryParameterNames.forEach { Log.i("asd", "param: " + it) }
        }
    }
}