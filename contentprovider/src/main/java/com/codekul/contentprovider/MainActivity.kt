package com.codekul.contentprovider

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import org.jetbrains.anko.listView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readCustom()
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

    fun readContact() {
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
