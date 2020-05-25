package com.handheld.agromalltest.fragments.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.handheld.agromalltest.databinding.DialogFarmerAddedBinding;

public class FarmerAddedDialog extends BottomSheetDialogFragment {
    DialogFarmerAddedBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=DialogFarmerAddedBinding.inflate(inflater);
        return binding.getRoot();
    }
}
