package com.codekul.contentprovider

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.ArrayAdapter
import org.jetbrains.anko.alert
import org.jetbrains.anko.listView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readContact()
    }

    private fun readCustom() {
        val dtSt = ArrayList<String>()

        val crsr = contentResolver.query(
                Uri.parse("content://com.codekul.my"),
                null,
                null,
                null,
                null
        )

        while (crsr.moveToNext()) {
            val id = crsr.getLong(
                    crsr.getColumnIndex("id")
            )
            val nm = crsr.getString(
                    crsr.getColumnIndex("nm")
            )

            val cost = crsr.getInt(
                    crsr.getColumnIndex("cost")
            )
            dtSt.add("""$nm \n $id \n $cost""")
        }

        crsr.close()

        verticalLayout {

            val lst = listView {
                adapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        dtSt
                )
            }
        }
    }

    private fun readContact() {

        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                    Manifest.permission.READ_CONTACTS)) {

                alert {
                    title = "Need Your permission"
                    message = "Wanna read contacts, Dont worry wont steal ur data"
                    iconResource = R.mipmap.ic_launcher
                    positiveButton("yes") {

                        ActivityCompat.requestPermissions(this@MainActivity,
                                arrayOf(Manifest.permission.READ_CONTACTS),
                                1234)
                    }
                }.show()

            } else {

                ActivityCompat.requestPermissions(this@MainActivity,
                        arrayOf(Manifest.permission.READ_CONTACTS),
                        1234)
            }
        } else redCon()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1234) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                redCon()
            }
        }
    }

    private fun redCon() {
        val dtSt = ArrayList<String>()

        val crsr = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                arrayOf(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                ),
                null,
                null,
                null
        )

        while (crsr.moveToNext()) {
            val nm = crsr.getString(
                    crsr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            )
            val num = crsr.getString(
                    crsr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            )

            dtSt.add("""$nm \n $num """)
        }

        crsr.close()

        verticalLayout {

            val lst = listView {
                adapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        dtSt
                )
            }
        }
    }
}
