package com.handheld.agromalltest.fragments.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Farmer {

    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
