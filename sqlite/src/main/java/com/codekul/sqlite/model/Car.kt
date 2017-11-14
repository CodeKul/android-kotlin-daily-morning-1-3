package com.codekul.sqlite.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aniruddha on 14/11/17.
 */
@Entity
class Car {

    @PrimaryKey
    var crId: Long? = null

    @ColumnInfo(name = "crNm")
    var crNm: String? = null

    @ColumnInfo(name = "crCst")
    var crCst: Int? = null

    constructor(crId: Long?, crNm: String?, crCst: Int?) {
        this.crId = crId
        this.crNm = crNm
        this.crCst = crCst
    }
}