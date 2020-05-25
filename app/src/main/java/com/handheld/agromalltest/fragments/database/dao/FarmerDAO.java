package com.handheld.agromalltest.fragments.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.handheld.agromalltest.fragments.models.Farmer;

import java.util.List;

@Dao
public interface FarmerDAO {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    Long insert(Farmer farmer);

    @Query("Select * from Farmer")
    List<Farmer> getFarmers();

    @Update
    void update(Farmer farmer);

    @Delete
    void delete(Farmer farmer);


}
