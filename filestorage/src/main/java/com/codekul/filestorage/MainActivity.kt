package com.codekul.filestorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout
import java.io.File
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            button("Read") {
                onClick {
                    rdPubExt()
                }
            }
            button("Write") {
                onClick {
                    wrtPubExt()
                }
            }
            button("More") {
                onClick {
                    val pthInt = File(filesDir, "my.txt")
                    Log.i("@codekul", """ Internal Storage Path - ${pthInt.absolutePath} """)

                    val pthExtPv = File(getExternalFilesDir("Downloads"), "my.txt")
                    Log.i("@codekul", """ External Storage Path ${pthExtPv.absolutePath} """)
                }
            }
        }
    }

    private fun readInternal() {

        //val fl = File(filesDir, "my.txt")
        val flDt = openFileInput("my.txt")
                .bufferedReader()
                .use {
                    it.readText()
                }
        Log.i("@codekul", "File data is " + flDt)
    }

    private fun writeInternal() {
        val flDt = "this is kotlin file writter"

        openFileOutput(
                "my.txt",
                Context.MODE_PRIVATE
        ).write(flDt.toByteArray())
    }

    private fun readExternal() {
        val flDt = File(getExternalFilesDir("Downloads"), "my.txt")
                .readText(Charset.defaultCharset())
        Log.i("@codekul", """ File data is $flDt """)
    }

    private fun writeExternal() {
        File(getExternalFilesDir("Downloads"), "my.txt")
                .writeText(
                        "This is getting stored on external storage",
                        Charset.defaultCharset()
                )
    }

    private fun rdPubExt() {
        val flDt = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "my.txt")
                .readText(Charset.defaultCharset())
        Log.i("@codekul", """ File data is $flDt """)
    }

    private fun wrtPubExt() {
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "my.txt")
                    .writeText(
                            "This is getting stored on external storage",
                            Charset.defaultCharset()
                    )
        }
    }
}
