package com.handheld.agromalltest.fragments.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handheld.agromalltest.databinding.FragmentCaptureFarmerDetailsBinding;
import com.handheld.agromalltest.fragments.models.Farmer;

public class CaptureFarmerDetailsFragment extends Fragment {

    private FragmentCaptureFarmerDetailsBinding binding;
    private FarmerDetailsInterface farmerDetailsInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentCaptureFarmerDetailsBinding.inflate(inflater);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Farmer farmer=new Farmer();
        binding.nextBtn.setOnClickListener(v->farmerDetailsInterface.farmerDetailsCaptured(farmer));
    }

    public void setFarmerDetailsInterface(FarmerDetailsInterface farmerDetailsInterface) {
        this.farmerDetailsInterface = farmerDetailsInterface;
    }

    public interface FarmerDetailsInterface{
        public void farmerDetailsCaptured(Farmer farmer);
    }

}
