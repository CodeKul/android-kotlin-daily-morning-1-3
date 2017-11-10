package com.codekul.sharedprefs

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = getSharedPreferences("my_prefs", Context.MODE_PRIVATE )

        verticalLayout {
            button("save") {
                onClick {
                    val editor = prefs.edit()
                    editor.putInt("myInt", 50)
                    editor.putFloat("myFloat", 50.6f)
                    editor.apply()
                }
            }
            button("read") {
                onClick {
                    Log.i("@codekul", """ Int ${prefs.getInt("myInt", -1)} Float ${prefs.getFloat("myFloat", -1f)}""" )
                }
            }
        }
    }
}
