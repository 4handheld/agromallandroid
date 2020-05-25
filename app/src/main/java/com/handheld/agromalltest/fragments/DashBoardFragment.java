package com.handheld.agromalltest.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handheld.agromalltest.R;
import com.handheld.agromalltest.databinding.FragmentDashBoardBinding;
import com.handheld.agromalltest.fragments.database.Database;

public class DashBoardFragment extends Fragment {

    private FragmentDashBoardBinding boardBinding;
    private DashBoardInterface dashBoardInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        boardBinding=FragmentDashBoardBinding.inflate(inflater);
        return boardBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        boardBinding.addFarmerBtn.setOnClickListener(v->dashBoardInterface.onAddFarmerRequest());
        boardBinding.textView2.setText(Database.getInstance(getContext()).getFarmerDAO().getFarmers().size()+"");
    }

    public void setDashBoardInterface(DashBoardInterface dashBoardInterface) {
        this.dashBoardInterface = dashBoardInterface;
    }

    public interface DashBoardInterface{

        public void onAddFarmerRequest();

    }

}
