package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SpaceActivity extends AppCompatActivity {
    private static String TAG = "SpaceActivity";
    private Button button1;
    private ImageView imageViewRocketIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout_03);

        button1 = findViewById(R.id.button1);
        imageViewRocketIcon = findViewById(R.id.imageViewRocketIcon);
        // 이벤트 리스너 등록
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
        button1.setOnClickListener(view -> {
            Log.d(TAG,"버튼이 클릭되었습니다.");
            Animation anim = AnimationUtils.loadAnimation(
                    getApplicationContext(),
                    R.anim.rotate_anim
            );
            imageViewRocketIcon.startAnimation(anim);
        });

    }
}

/*
 1.  새로운 액티비티 만들기
 2. setContentView 메서드 안에 R.layout.constraint_02
 3. 매니 페스트 파일에 첫 화면을 세팅
 4. 이벤트 리스너
 5. 애니메이션을 연결해서 동작시키기
* */