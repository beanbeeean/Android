package com.example.ytsmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.ytsmovie.databinding.ActivityMainBinding;
import com.example.ytsmovie.interfaces.OnPageTypeChange;
import com.example.ytsmovie.models.YtsData;
import com.example.ytsmovie.repository.MovieService;
import com.example.ytsmovie.utils.Define;
import com.example.ytsmovie.utils.FragmentType;
import com.google.android.material.appbar.MaterialToolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnPageTypeChange {

    // 1. viewBinding 사용하기
    private ActivityMainBinding binding;

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // viewBinding 설정 방법 (Activity)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();

    }

    private void initData() {
        addTopAppbarEventListener();
        addBottomNavigationListener();
        replaceFragment(FragmentType.MOVIE);

    }

    private void addTopAppbarEventListener() {
        binding.topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.favorite) {

                    // 새로운 화면을 띄움

                }
                return true;
            }
        });
    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.getInstance(this);
        } else {
            fragment = InfoFragment.getInstance(this);
        }

        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();

    }

    private void addBottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_1:
                    replaceFragment(FragmentType.MOVIE);
                    break;
                case R.id.page_2:
                    replaceFragment(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }

    /**
     * 콜백 메서드
     * @param title : app title 변수
     */
    @Override
    public void typeToolbarChange(String title) {
        // 여기에 알람이 옴.
        MaterialToolbar toolbar = binding.topAppBar;
        if (title.equals(Define.PAGE_TITLE_MOVIE)) {
            toolbar.setTitle(title);
            toolbar.setVisibility(View.VISIBLE);
        } else {
            toolbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("TAG", "액티비티에서 이벤트 캐치");
        //super.onBackPressed();
        // 여기에서 이벤트가 들어왔을때
        // 현재 화면에 movie, info 중 확인 한 후
        // info --> movie(화면 이동)
        // movie --> (앱 종료)

        // INFO
        String fragmentByTag = getSupportFragmentManager()
                .findFragmentByTag(FragmentType.INFO.toString()).getTag();

        if (fragmentByTag.equals(FragmentType.INFO.toString())) {
            replaceFragment(FragmentType.MOVIE);
        } else {
            super.onBackPressed();
            ;
        }
    }
}