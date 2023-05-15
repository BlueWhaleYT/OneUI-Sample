package com.bluewhaleyt.oneuisample.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bluewhaleyt.oneuisample.R;
import com.bluewhaleyt.oneuisample.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public int getIconResId() {
        return dev.oneuiproject.oneui.R.drawable.ic_oui_home_outline;
    }

    @Override
    public CharSequence getTitle() {
        return "Home";
    }

    @Override
    public boolean isAppBarEnabled() {
        return true;
    }
}
