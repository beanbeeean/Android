package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createFragmentButton;
    private Button removeFragmentButton;
    private OneFragment oneFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "Activity : onCreate ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFragmentButton = findViewById(R.id.createFragmentButton);
        removeFragmentButton = findViewById(R.id.removeFragmentButton);
        oneFragment = new OneFragment();

        // 데이터를 전달하는 방법
        Bundle bundle = new Bundle();
        bundle.putString("param1","안녕하세요");
        oneFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        // FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        createFragmentButton.setOnClickListener(view -> {
            // 자바 코드로 프래그먼트를 생성하는 방법
            // oneFragment = new OneFragment();

            // 1. FragmentManager (프래그먼트 트랜잭션 객체를 가져올 수 있다)
            // 2. FragmentTransaction -> 작업의 단위 (시작과 끝이 있다)
            // FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // replace(교체) | add(추가)
            fragmentTransaction.replace(R.id.fragmentContainer, oneFragment);
            fragmentTransaction.commit();
            // commit() : 시간이 될 때 완료
            // commitNow() : 지금 당장 완료
            // commitAllowingStateLoss() : 위험 (커밋이 없어질 수 있음)

        });

        removeFragmentButton.setOnClickListener(view -> {
            // JAVA 코드로 Fragment 제거하기
            // remove | detach
            // remove : 인스턴스를 다시 연결할 수 없다 -> 다시 만드려면 프래그먼트 트랜잭션에 다시 추가해야한다.
            // FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(oneFragment);
            fragmentTransaction.commit();
        });
    }

    @Override
    protected void onStart() {
        Log.d("TAG", "Activity : onStart ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("TAG", "Activity : onResume ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("TAG", "Activity : onPause ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("TAG", "Activity : onStop ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("TAG", "Activity : onDestroy ");
        super.onDestroy();
    }

}