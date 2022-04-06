package com.example.myapp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText heightEt = findViewById(R.id.heightEt);
        EditText weightEt = findViewById(R.id.weightEt);
        Button btnOk = findViewById(R.id.btn_ok);

        // 이벤트 리스너 등록
        btnOk.setOnClickListener(view -> {
            // 값 --> String --> int
            String height = heightEt.getText().toString();
            String weight = weightEt.getText().toString();

            if(height.length() < 1 || weight.length() < 1) {
                Toast.makeText(this, "빈 값이 있습니다", Toast.LENGTH_SHORT).show();
            }else{
                // 목표 : 인텐트를 사용해 다른 화면으로 값을 전송
                Intent intent = new Intent(this,ResultActivity.class);
                intent.putExtra("height",Integer.parseInt(height));
                intent.putExtra("weight",Integer.parseInt(weight));
                startActivity(intent);
            }

        });
    }
}