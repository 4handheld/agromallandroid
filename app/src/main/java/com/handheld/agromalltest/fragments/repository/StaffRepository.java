package com.handheld.agromalltest.fragments.repository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.handheld.agromalltest.fragments.viewmodels.StaffViewModel;

public class StaffRepository {

    StaffViewModel viewModel;

    public StaffRepository(){
//        viewModel= ViewModelProvider.Factory
    }

    public boolean login(String email,String password){
        return ("test@theagromall.com".contentEquals(email)) && ("password".contentEquals(password));
    }

    public StaffViewModel getStaff(){
        return  viewModel;
    }

}
