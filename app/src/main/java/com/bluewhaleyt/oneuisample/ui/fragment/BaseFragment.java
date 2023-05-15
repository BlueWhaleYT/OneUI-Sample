package com.bluewhaleyt.oneuisample.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements FragmentInfo {

    protected Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    public abstract int getLayoutResId();

    public abstract int getIconResId();

    public abstract CharSequence getTitle();

    @Override
    public boolean isAppBarEnabled() {
        return true;
    }
}