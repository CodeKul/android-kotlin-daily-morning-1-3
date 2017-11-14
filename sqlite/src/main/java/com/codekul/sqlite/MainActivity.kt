package com.codekul.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.persistence.room.Room
import android.util.Log
import android.widget.EditText
import com.codekul.sqlite.db.AppDb
import com.codekul.sqlite.model.Car
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.find
import org.jetbrains.anko.verticalLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(applicationContext,
                AppDb::class.java, "android-db").build()

        val carDao = db.carDao()

        verticalLayout {
            val crNm = editText {
                hint = "name"
                id = R.id.edtNm
            }

            val cost = editText {
                hint = "cost"
                id = R.id.edtCost
            }

            button("Insert") {
                carDao.insert(
                        Car(
                                12,
                                crNm.text.toString(),
                                cost.text.toString().toInt()
                        )
                )
            }

            button("Update") {

            }

            button("Delete") {

            }

            button("Query") {
                carDao.select().forEach {
                    Log.i("@codekul", "Name - ${it.crNm} Cost ${it.crCst} Id - ${it.crId}")
                }
            }
        }
    }
}
