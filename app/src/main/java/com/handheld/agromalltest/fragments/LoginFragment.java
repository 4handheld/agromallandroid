package com.handheld.agromalltest.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handheld.agromalltest.databinding.FragmentLoginBinding;
import com.handheld.agromalltest.fragments.repository.StaffRepository;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private StaffRepository repository;
    private LoginFragmentInterface loginFragmentInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository=new StaffRepository();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentLoginBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button2.setOnClickListener(v->login());
    }

    private void login(){
      boolean done=  repository.login(binding.editText2.getText().toString(),binding.editText.getText().toString());
      if(loginFragmentInterface!=null)
      loginFragmentInterface.onLogin(done);
    }

    public void setLoginFragmentInterface(LoginFragmentInterface loginFragmentInterface) {
        this.loginFragmentInterface = loginFragmentInterface;
    }

    public interface LoginFragmentInterface{
        public void onLogin(boolean done);
    }

}
