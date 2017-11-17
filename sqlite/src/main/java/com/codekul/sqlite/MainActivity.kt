package com.codekul.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.persistence.room.Room
import android.util.Log
import com.codekul.sqlite.db.AppDb
import com.codekul.sqlite.model.Car
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.verticalLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(this,
                AppDb::class.java, "android-db.db").build()

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

                val car = Car()
                car.crCst = cost.text.toString().toInt()
                car.crNm = crNm.text.toString()

                carDao.insert(car)
            }

            button("Update") {

            }

            button("Delete") {

            }

            button("Query") {
                carDao.select().forEach {
                    Log.i("@codekul", """ Name - ${it.crNm}  Cost - ${it.crCst}  Id - ${it.crId} """)
                }
            }
        }
    }
}
