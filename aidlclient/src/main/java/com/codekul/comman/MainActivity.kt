package com.codekul.comman

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.R.attr.name
import android.content.pm.ResolveInfo
import android.content.pm.PackageManager



class MainActivity : AppCompatActivity() {

    var calc: IComman? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onBindWith(view: View?) {

        val intent = Intent("com.codekul.action.CALC")
        bindService(convertToImplicit(intent), object : ServiceConnection {
            override fun onServiceDisconnected(p0: ComponentName?) {
                calc = null
            }

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                calc = IComman.Stub.asInterface(p1)
            }

        }, Context.BIND_AUTO_CREATE)
    }

    fun onCalculate(view: View?) {
        Log.i("@codekul", """ Calculation is ${calc?.calculate(13, 15, '+')} """)
    }

    private fun convertToImplicit(implicitIntent: Intent): Intent? {
        // Retrieve all services that can match the given intent
        val pm = packageManager
        val resolveInfo = pm.queryIntentServices(implicitIntent, 0)

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size != 1) {
            return null
        }

        // Get component info and create ComponentName
        val serviceInfo = resolveInfo[0]
        val packageName = serviceInfo.serviceInfo.packageName
        val className = serviceInfo.serviceInfo.name
        val component = ComponentName(packageName, className)

        // Create a new intent. Use the old one for extras and such reuse
        val explicitIntent = Intent(implicitIntent)

        // Set the component to be explicit
        explicitIntent.component = component

        return explicitIntent
    }

}
