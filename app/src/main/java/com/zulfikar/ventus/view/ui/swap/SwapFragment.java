package com.zulfikar.ventus.view.ui.swap;

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

public class SwapFragment extends Fragment {

    private SwapViewModel swapViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        swapViewModel =
                new ViewModelProvider(this).get(SwapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_swap, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        swapViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}