package com.example.guiabarcelona;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.guiabarcelona.databinding.FragmentPlacesBinding;

import java.util.List;

public class PlacesFragment extends Fragment {

    private static final String ARG_CATEGORY = "arg_category";

    private FragmentPlacesBinding binding;

    public static PlacesFragment newInstance(int category) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlacesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int category = requireArguments().getInt(ARG_CATEGORY);
        List<Place> places = PlacesRepository.getPlaces(category);

        binding.recyclerPlaces.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerPlaces.setAdapter(new PlacesAdapter(places, place -> {
            Intent intent = new Intent(requireContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_PLACE, place);
            startActivity(intent);
        }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
