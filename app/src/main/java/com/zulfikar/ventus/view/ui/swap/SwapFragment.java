package com.zulfikar.ventus.view.ui.swap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zulfikar.ventus.R;
import com.zulfikar.ventus.view.HomeActivity;
import com.zulfikar.ventus.view.SectionFragment;
import com.zulfikar.ventus.view.StudyFragment;

public class SwapFragment extends Fragment {

    private SwapViewModel swapViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        swapViewModel =
                new ViewModelProvider(this).get(SwapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_swap, container, false);
        swapViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        BottomNavigationView navView = root.findViewById(R.id.swap_nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_section_fragment:
                        selectedFragment = new SectionFragment();
                        break;
                    case R.id.nav_study_fragment:
                        selectedFragment = new StudyFragment();
                        break;
                }

                HomeActivity.me.getSupportFragmentManager().beginTransaction().replace(R.id.swap_fragment, selectedFragment).commit();

                return true;
            }
        });
        return root;
    }
}