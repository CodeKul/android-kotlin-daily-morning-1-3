package com.codekul.sqlitejava;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


/**
 * Created by aniruddha on 16/11/17.
 */

@Database(entities = {Car.class}, version = 1)
public abstract class AppDb extends RoomDatabase{

    public abstract CarDao carDao();
}
