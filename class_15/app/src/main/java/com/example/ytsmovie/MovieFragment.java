package com.example.ytsmovie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ytsmovie.adapter.MovieAdapter;
import com.example.ytsmovie.databinding.FragmentMovieBinding;
import com.example.ytsmovie.interfaces.OnPageTypeChange;
import com.example.ytsmovie.models.Movie;
import com.example.ytsmovie.models.YtsData;
import com.example.ytsmovie.repository.MovieService;
import com.example.ytsmovie.utils.Define;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment {

    private static final String TAG = MovieFragment.class.getName();
    private FragmentMovieBinding binding; // viewBinding
    private static MovieFragment movieFragment; // 싱글톤 패턴
    private MovieAdapter movieAdapter;
    private LinearLayoutManager linearLayoutManager;
    private MovieService service;
    private final OnPageTypeChange onPageTypeChange;

    private int currentPageNumber = 1;
    private static final int DATA_LIMIT = 10;
    private List<Movie> movieList = new ArrayList<>();
    private boolean preventDuplicateScrollEvent = true;
    private boolean isFirstFragmentStart = true;

    List<Movie> temp = new ArrayList<>();

    private MovieFragment(OnPageTypeChange onPageTypeChange) {
        this.onPageTypeChange = onPageTypeChange;
    }

    public static MovieFragment getInstance(OnPageTypeChange onPageTypeChange) {
        if (movieFragment == null) {
            movieFragment = new MovieFragment(onPageTypeChange);
        }
        return movieFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = MovieService.retrofit.create(MovieService.class);
        onPageTypeChange.typeToolbarChange(Define.PAGE_TITLE_MOVIE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Fragment에서 viewBinding 사용법
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();
        if (isFirstFragmentStart) {
            requestMoviesData(currentPageNumber);
        } else {
            binding.progressIndicator.setVisibility(View.GONE);
        }

    }

    private void initRecyclerView() {
        // 1. 어댑터
        // 2. 매니저
        // 3. 셋팅
        movieAdapter = new MovieAdapter(getContext());
        movieAdapter.addItem(movieList);

        linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = binding.movieRecyclerView;

        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.hasFixedSize();
        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if (preventDuplicateScrollEvent) {

                    int lastVisibleItemPosition =
                            ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    int itemTotalCount = recyclerView.getAdapter().getItemCount() - 1;

                    if (lastVisibleItemPosition == itemTotalCount) {
                        // Toast.makeText(getContext(), "마지막 위치 입니다!", Toast.LENGTH_SHORT).show();
                        // 통신 요청
                        requestMoviesData(currentPageNumber);
                        preventDuplicateScrollEvent = false;
                    }
                }

            }
        });
    }

    private void requestMoviesData(int page) {
        String orderBy = "rating";

        service.repoContributors(orderBy, page, DATA_LIMIT)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            YtsData ytsData = response.body();
                            // List<Movie> list = ytsData.getData().getMovies();
                            movieList = ytsData.getData().getMovies();
                            movieAdapter.addItem(ytsData.getData().getMovies());
                            currentPageNumber++; // 2
                            preventDuplicateScrollEvent = true;
                            isFirstFragmentStart = false;
                            binding.progressIndicator.setVisibility(View.GONE);

                            temp = ytsData.getData().getMovies();

                        } else {
                            // assert 란 개발자들이 디버깅을 빠르게 하기위한 도구
                            // 즉, 에러 검출용 코드이자 코드를 다 완성하고 동작할 때 돌어가는 함수가 아니다.
                            // log 보다 더 효율적으로 상용될 수 있다.
                            // 컴파일, 실제 앱을 배포 (컴파일러가 무시)
                            assert response.errorBody() != null;
                            Log.d(TAG, response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }
}