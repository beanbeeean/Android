package com.example.myfragment.adapter;

public class AirConditioner implements Electronic220v{

    @Override
    public void connect() {
        System.out.println("에어컨 연결 220v On");
    }
}
