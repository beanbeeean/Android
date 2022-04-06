package com.example.ytsmovie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.ytsmovie.databinding.FragmentBottomSheetBinding;
import com.example.ytsmovie.models.Movie;


public class BottomSheetFragment extends Fragment {

    private FragmentBottomSheetBinding binding;

    private Movie movie;

    public BottomSheetFragment(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBottomSheetBinding.inflate(inflater,container,false);

        Glide.with(this)
                .load(movie.getMediumCoverImage())
                .into(binding.movieImageView);

        binding.summaryTextView.setText(movie.getSummary());
        binding.descriptionTextView.setText(movie.getDescriptionFull());
        binding.synopsisTextView.setText(movie.getSynopsis());

        return binding.getRoot();
    }
}