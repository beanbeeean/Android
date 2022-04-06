package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SpaceActivity2 extends AppCompatActivity {

    private static String TAG = "SpaceAct";
    private Button btn;
    private ImageView galaxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout_02);

        btn = findViewById(R.id.footer);
        galaxy = findViewById(R.id.galaxy);

        btn.setOnClickListener(view -> {
            Log.d(TAG,"버튼이 클릭되어 회전합니다");
            Animation anim = AnimationUtils.loadAnimation(
                    getApplicationContext(),
                    R.anim.rotate_anim
            );

            galaxy.startAnimation(anim);
        });
    }
}