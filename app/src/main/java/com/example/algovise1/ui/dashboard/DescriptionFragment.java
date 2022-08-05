package com.example.algovise1.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.algovise1.Algorithm;
import com.example.algovise1.databinding.FragmentDescriptionBinding;

import org.json.JSONObject;

public class DescriptionFragment extends Fragment {

    private FragmentDescriptionBinding binding;
    LinearLayout rootView;
    String descJson;
    JSONObject descObject;
    public static DescriptionFragment newInstance(String algorithm) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Algorithm.KEY_ALGORITHM, algorithm);
        fragment.setArguments(bundle);
        return fragment;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDescriptionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}