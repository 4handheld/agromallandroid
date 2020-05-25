package com.handheld.agromalltest.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.handheld.agromalltest.R;
import com.handheld.agromalltest.databinding.ActivityMainBinding;
import com.handheld.agromalltest.fragments.DashBoardFragment;
import com.handheld.agromalltest.fragments.LoginFragment;
import com.handheld.agromalltest.fragments.database.Database;
import com.handheld.agromalltest.fragments.dialog.FarmerAddedDialog;
import com.handheld.agromalltest.fragments.fragments.CaptureFarmDetailsFragment;
import com.handheld.agromalltest.fragments.fragments.CaptureFarmerDetailsFragment;
import com.handheld.agromalltest.fragments.fragments.CapturePhotographFragment;
import com.handheld.agromalltest.fragments.models.Farm;
import com.handheld.agromalltest.fragments.models.Farmer;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Database database;
    private FarmerAddedDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        database=Database.getInstance(this);
        dialog=new FarmerAddedDialog();
        displayLoginFragment();
    }

    private void displayLoginFragment(){
        LoginFragment loginFragment=new LoginFragment();
        loginFragment.setLoginFragmentInterface(new LoginFragment.LoginFragmentInterface() {
            @Override
            public void onLogin(boolean done) {
                displayDashBoard();
            }
        });
         getSupportFragmentManager().beginTransaction()
         .replace(binding.content.getId(),loginFragment)
         .commit();
    }

    public void displayDashBoard(){
        DashBoardFragment dashBoardFragment=new DashBoardFragment();
        dashBoardFragment.setDashBoardInterface(new DashBoardFragment.DashBoardInterface() {
            @Override
            public void onAddFarmerRequest() {
                displayCaptureFarmerDetails();//displayAddFarmerCapturePhotograph();
            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(binding.content.getId(),dashBoardFragment)
                .commit();
    }

    public void displayAddFarmerCapturePhotograph(){
        CapturePhotographFragment fragment =new CapturePhotographFragment();
        fragment.setPhotographInterface(new CapturePhotographFragment.PhotographInterface() {
            @Override
            public void onImageCaptured() {
              displayCaptureFarmDetails();
            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(binding.content.getId(),fragment)
                .commit();
    }

    public void displayCaptureFarmDetails(){
        CaptureFarmDetailsFragment fragment=new CaptureFarmDetailsFragment();
        fragment.setCaptured(new CaptureFarmDetailsFragment.FarmDetailsCaptured() {
            @Override
            public void FarmCaptured(Farm farm) {
                displayCaptureFarmerDetails();
            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(binding.content.getId(),fragment)
                .commit();
    }

    public void displayCaptureFarmerDetails(){
        CaptureFarmerDetailsFragment fragment=new CaptureFarmerDetailsFragment();
        fragment.setFarmerDetailsInterface(new CaptureFarmerDetailsFragment.FarmerDetailsInterface() {
            @Override
            public void farmerDetailsCaptured(Farmer farmer) {
                database.getFarmerDAO().insert(new Farmer());
                try {
                    dialog.show(getSupportFragmentManager(), dialog.getTag());
                }catch (Exception e){
                    //Log e
                }

            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(binding.content.getId(),fragment)
                .commit();
    }

}
