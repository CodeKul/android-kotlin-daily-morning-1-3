package com.codekul.sqlite.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aniruddha on 14/11/17.
 */
@Entity
class Car {

    @PrimaryKey
    var crId: Long? = 0

    var crNm: String? = ""

    var crCst: Int? = 0
}

