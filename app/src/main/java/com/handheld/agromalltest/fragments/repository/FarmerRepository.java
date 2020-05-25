package com.handheld.agromalltest.fragments.repository;

import androidx.lifecycle.MutableLiveData;

import com.handheld.agromalltest.fragments.database.Database;
import com.handheld.agromalltest.fragments.models.Farmer;
import com.handheld.agromalltest.fragments.viewmodels.FarmerViewModel;

import java.util.List;

public class FarmerRepository {

    private MutableLiveData<List<FarmerViewModel>> farmerList;
    Database db;

    public void addFarmer(Farmer farmer){

    }

    public MutableLiveData<List<FarmerViewModel>> getFarmers(){
        return farmerList;
    }


}
