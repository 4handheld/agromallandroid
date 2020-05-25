package com.handheld.agromalltest.fragments.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.handheld.agromalltest.databinding.FragmentCaptureDetailsBinding;
import com.handheld.agromalltest.fragments.models.Farm;


public class CaptureFarmDetailsFragment extends Fragment {

    private FragmentCaptureDetailsBinding binding;
    private FarmDetailsCaptured captured;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentCaptureDetailsBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Farm farm=new Farm();
        binding.nextBtn.setOnClickListener(v->captured.FarmCaptured(farm));
    }

    public void setCaptured(FarmDetailsCaptured captured) {
        this.captured = captured;
    }

    public interface FarmDetailsCaptured{
        public void FarmCaptured(Farm farm);
    }

    public void requestMapSearch(){
        Intent t=new Intent();

    }
}
