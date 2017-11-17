package com.codekul.sqlite.dao

import android.arch.persistence.room.*
import com.codekul.sqlite.model.Car

/**
 * Created by aniruddha on 14/11/17.
 */
@Dao
interface CarDao {

    @Insert
    fun insert(car: Car)

    @Update
    fun update(car: Car)

    @Delete
    fun delete(id: Long)

    @Query("select * from Car")
    fun select(): List<Car>
}
