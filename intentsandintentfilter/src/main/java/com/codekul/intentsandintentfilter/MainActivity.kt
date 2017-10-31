package com.codekul.intentsandintentfilter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOkay.setOnClickListener {
           web()
        }
    }

    private fun dial() {
        val calInt = Intent(Intent.ACTION_DIAL)
        startActivity(calInt)
    }

    private fun call() {
        val calInt = Intent(Intent.ACTION_CALL)
        calInt.data = Uri.parse("tel://9732548833")
        startActivity(calInt)
    }

    private fun web() {
        val webInt = Intent(Intent.ACTION_VIEW)
        webInt.data = Uri.parse("http://codekul.com")
        startActivity(webInt)
    }

    private fun simple() {
        val inte = Intent()
        inte.action = "com.codekul.action.SIMPLE"
        inte.addCategory("com.codekul.category.PQR")
        inte.data = Uri.parse("http://codekul.com")
        startActivity(inte)
    }
}

fun hello() {

    fun inHe() {

    }

    fun inHello2() {
        inHe()
    }
}
