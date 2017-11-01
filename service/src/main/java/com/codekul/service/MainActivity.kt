package com.codekul.service

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    var intentSer: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentSer = Intent(this, MyService::class.java)
    }

    fun onMpStart(view: View?) {
        startService(intentSer)
    }

    fun onMpStop(view: View?) {
        stopService(intentSer)
    }
}
