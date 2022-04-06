package com.example.ytsmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.ytsmovie.databinding.ActivityDetailBinding;
import com.example.ytsmovie.models.Movie;
import com.example.ytsmovie.utils.Define;

public class DetailActivity extends AppCompatActivity {

    private final static String TAG = DetailActivity.class.getName();
    private ActivityDetailBinding binding;
    private BottomSheetFragment bottomSheetFragment;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getIntent() != null){
            movie = (Movie) getIntent().getSerializableExtra(Define.PARAM_MOVIE_OBJ);
            initData();
            addEventListener();
        }
    }

    private void initData() {
        binding.titleTextView.setText(movie.getTitle());
        binding.yearTextView.setText("제작년도 : " + movie.getYear() + "년");
        binding.runTimeTextView.setText("상영시간 : " + movie.getRuntime() + "분");

        Glide.with(this)
                .load(movie.getMediumCoverImage())
                .into(binding.moviePoster);

        Glide.with(this)
                .load(movie.getBackgroundImage())
                .into(binding.backgroundImageView);

        bottomSheetFragment = new BottomSheetFragment(movie);
    }


    private void addEventListener() {
        binding.showContentButton.setOnClickListener(view -> {
            addFragment();
        });
    }

    private void addFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setCustomAnimations(R.anim.slide_in_bottom,R.anim.slide_out_bottom);
        transaction.setReorderingAllowed(true);
        transaction.replace(binding.bottomSheetContainer.getId(),bottomSheetFragment);
        transaction.commit();
    }
}