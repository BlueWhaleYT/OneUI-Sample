package com.bluewhaleyt.oneuisample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.bluewhaleyt.oneuisample.databinding.ActivityMainBinding;
import com.bluewhaleyt.oneuisample.ui.drawer.DrawerListAdapter;
import com.bluewhaleyt.oneuisample.ui.fragment.FragmentInfo;
import com.bluewhaleyt.oneuisample.ui.fragment.HomeFragment;
import com.bluewhaleyt.oneuisample.ui.fragment.preferences.PreferencesFragment;

import java.util.ArrayList;
import java.util.List;

import dev.oneuiproject.oneui.layout.DrawerLayout;
import dev.oneuiproject.oneui.widget.Toast;

public class MainActivity extends AppCompatActivity implements DrawerListAdapter.DrawerListener {

    private ActivityMainBinding binding;

    private List<Fragment> listFragment = new ArrayList<>();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupFragmentList();
        setupFragments();
        setupDrawer(binding.drawerLayout, binding.drawerListView);
    }

    @Override
    public void onBackPressed() {
        // Fix O memory leak
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O
                && isTaskRoot()
                && fragmentManager.getBackStackEntryCount() == 0) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
    }

    private void setupFragmentList() {
        // add(null) means add a separator line
        listFragment.add(new HomeFragment());
        listFragment.add(null);
        listFragment.add(new PreferencesFragment());
    }

    private void setupFragments() {
        fragmentManager = getSupportFragmentManager();
        var transaction = fragmentManager.beginTransaction();
        for (Fragment fragment : listFragment) {
            if (fragment != null) transaction.add(R.id.frame_layout, fragment);
        }
        transaction.commit();
        fragmentManager.executePendingTransactions();

        onDrawerItemSelected(0); // open first fragment on start
    }

    private void setupDrawer(DrawerLayout d, RecyclerView dlv) {
        d.setDrawerButtonIcon(getDrawable(dev.oneuiproject.oneui.R.drawable.ic_oui_audio_noti));
        d.setDrawerButtonBadge(2);
        d.setDrawerButtonOnClickListener(v -> {
            Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
        });

        dlv.setLayoutManager(new LinearLayoutManager(this));
        dlv.setItemAnimator(null);
        dlv.setHasFixedSize(true);
        dlv.seslSetLastRoundedCorner(false);
        dlv.setAdapter(new DrawerListAdapter(this, listFragment, this));
    }

    @Override
    public boolean onDrawerItemSelected(int position) {
        var d = binding.drawerLayout;
        var newFragment = listFragment.get(position);
        var transaction = fragmentManager.beginTransaction();
        for (Fragment fragment : fragmentManager.getFragments()) {
            transaction.hide(fragment);
        }
        transaction.show(newFragment).commit();

        if (newFragment instanceof FragmentInfo) {
            if (!((FragmentInfo) newFragment).isAppBarEnabled()) {
                d.setExpanded(false, false);
                d.setExpandable(false);
            } else {
                d.setExpandable(true);
                d.setExpanded(false, false);
            }
            d.setTitle(getString(R.string.app_name), ((FragmentInfo) newFragment).getTitle());
            d.setExpandedSubtitle(((FragmentInfo) newFragment).getTitle());
        }
        d.setDrawerOpen(false, true);

        return true;
    }
}