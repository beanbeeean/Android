package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 1 ~ 9 선언
    TextView one;
    TextView two;
    TextView three;
    TextView four;
    TextView five;
    TextView six;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView zero;
    TextView ca;
    TextView plus;
    TextView result;

    String newValue = "0";
    String oldValue = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_01);
        initData();
        addEventListener();

    }

    private void initData() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);
    }

    private void addEventListener() {
        one.setOnClickListener(view -> {
            newValue = newValue + "1";

            result.setText(newValue);
        });

        two.setOnClickListener(view -> {
            // 1 + 2 (기존에 사용했던 값 + 새로 들어가는 값
            // "1" + "2" = "12"

            newValue += "2";
            result.setText(newValue);
        });

        three.setOnClickListener(view -> {
            newValue += "3";
            result.setText(newValue);
        });

        four.setOnClickListener(view -> {
            newValue += "4";
            result.setText(newValue);
        });

        five.setOnClickListener(view -> {
            newValue += "5";
            result.setText(newValue);
        });

        six.setOnClickListener(view -> {
            newValue += "6";
            result.setText(newValue);
        });

        seven.setOnClickListener(view -> {
            newValue += "7";
            result.setText(newValue);
        });

        eight.setOnClickListener(view -> {
            newValue += "8";
            result.setText(newValue);
        });

        nine.setOnClickListener(view -> {
            newValue += "9";
            result.setText(newValue);
        });

        zero.setOnClickListener(view -> {
            newValue += "0";
            result.setText(newValue);
        });

        ca.setOnClickListener(view -> {
            newValue = "0";
            result.setText(newValue);
        });

        plus.setOnClickListener(view -> {
            // 연산
            int number1 = Integer.parseInt(newValue);
//            if(oldValue == ""){
//                oldValue = "0";
//            }
            int number2 = Integer.parseInt(oldValue);
            int sum = (number1 + number2);

            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);
        });

        result.setOnClickListener(view -> {

        });

    }
}