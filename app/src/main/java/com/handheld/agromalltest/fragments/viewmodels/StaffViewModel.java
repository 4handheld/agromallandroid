package com.handheld.agromalltest.fragments.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.handheld.agromalltest.fragments.models.User;

public class StaffViewModel extends ViewModel {

    MutableLiveData<User> user=new MutableLiveData<>();

    public MutableLiveData<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }
}
