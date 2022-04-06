package com.example.myfragment.singleton;

public class AClass {

    private MyPrinter myPrinter;

    public AClass() {
        myPrinter = MyPrinter.getInstance();
    }

    public MyPrinter getMyPrinter() {
        return this.myPrinter;
    }
}
