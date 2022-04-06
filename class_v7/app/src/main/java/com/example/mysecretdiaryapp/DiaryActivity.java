package com.example.mysecretdiaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        SharedPreferences diaryPreferences =
                getSharedPreferences("diary", Context.MODE_PRIVATE);
        String userText = diaryPreferences.getString("diary", "");

        diaryEditText = findViewById(R.id.diaryEditText);
        diaryEditText.setText(userText);

        // thread 기능 구현
        Runnable runnable = () -> {
            SharedPreferences preferences =
                    getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit(); // 수정모드
            editor.putString("diary", diaryEditText.getText().toString());
            editor.apply();
        };


        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}