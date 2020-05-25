package com.handheld.agromalltest.fragments.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.handheld.agromalltest.fragments.database.dao.FarmerDAO;
import com.handheld.agromalltest.fragments.models.Farmer;

@androidx.room.Database(entities = {Farmer.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public static synchronized Database getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context,Database.class,"App_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract FarmerDAO getFarmerDAO();

}
