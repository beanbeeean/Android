package com.example.myrecyclerview.observer;

public class MainTest {

    public static void main(String[] args) {

        Button myButton = new Button("우리가 만든 버튼");

        myButton.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println("동작을 확인 합니다 !!! " + event);
            }
        });

        myButton.click("안녕하세요~~~");
        myButton.click("hi~~~");
        myButton.click("hello~~~");
        myButton.click("ABC");
    }
}
