package com.codekul.sqlitejava;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by aniruddha on 16/11/17.
 */

@Entity
public class Car {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String nm;
    private Integer cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
