package com.bluewhaleyt.oneuisample.ui.fragment.preferences;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;

import com.bluewhaleyt.oneuisample.R;
import com.bluewhaleyt.oneuisample.ui.fragment.FragmentInfo;

public class PreferencesFragment extends PreferenceFragmentCompat implements FragmentInfo {

    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().setBackgroundColor(context.getColor(dev.oneuiproject.oneui.design.R.color.oui_background_color));
        getListView().seslSetLastRoundedCorner(false);
    }

    @Override
    public int getLayoutResId() {
        return -1;
    }

    @Override
    public int getIconResId() {
        return dev.oneuiproject.oneui.R.drawable.ic_oui_settings_outline;
    }

    @Override
    public CharSequence getTitle() {
        return "Preferences";
    }

    @Override
    public boolean isAppBarEnabled() {
        return true;
    }

}
