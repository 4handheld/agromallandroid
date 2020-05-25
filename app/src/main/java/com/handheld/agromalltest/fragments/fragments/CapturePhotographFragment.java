package com.handheld.agromalltest.fragments.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handheld.agromalltest.databinding.FragmentCapturePhotographBinding;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.PictureResult;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class CapturePhotographFragment extends Fragment {
    private FragmentCapturePhotographBinding binding;
    private PhotographInterface photographInterface;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentCapturePhotographBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(@NonNull PictureResult result) {
                super.onPictureTaken(result);
//                result.toFile();
            }
        });
        binding.nextBtn.setOnClickListener(v->photographInterface.onImageCaptured());
    }


    @Override
    public void onResume() {
        super.onResume();
        binding.cameraView.open();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.cameraView.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.cameraView.destroy();
    }


    public void setPhotographInterface(PhotographInterface photographInterface) {
        this.photographInterface = photographInterface;
    }

    public interface PhotographInterface{
        public void onImageCaptured();
    }
}
