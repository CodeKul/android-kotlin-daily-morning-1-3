package com.codekul.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(con: Context?, data: Intent?) {
            Log.i("@codekul", "Airplane Mode Changed")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intFil = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        //registerReceiver(receiver, intFil)
    }
}
