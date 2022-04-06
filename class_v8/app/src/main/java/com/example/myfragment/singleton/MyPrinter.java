package com.example.myfragment.singleton;

public class MyPrinter {

    private static MyPrinter myPrinter;

    // 1. private /// new MyPrinter() -- X (다른 클래스에서 호출안됨)
    private MyPrinter() {

    }

    public static MyPrinter getInstance() {
        if(myPrinter == null){
            myPrinter = new MyPrinter();
        }
        return myPrinter;
    }

}
