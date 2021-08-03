package com.zulfikar.ventus.view.ui.review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.zulfikar.ventus.R;

public class ReviewFragment extends Fragment {

    private ReviewViewModel reviewViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reviewViewModel =
                new ViewModelProvider(this).get(ReviewViewModel.class);
        View root = inflater.inflate(R.layout.fragment_review, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        reviewViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}