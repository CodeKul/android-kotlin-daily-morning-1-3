package com.codekul.sqlite.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.codekul.sqlite.dao.CarDao
import com.codekul.sqlite.model.Car

/**
 * Created by aniruddha on 14/11/17.
 */

@Database(
        entities = arrayOf(
                Car::class
        ),
        version = 1
)
abstract class AppDb : RoomDatabase() {
    abstract fun carDao(): CarDao
}