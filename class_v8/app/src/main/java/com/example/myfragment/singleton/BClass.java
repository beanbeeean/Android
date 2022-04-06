package com.example.myfragment.singleton;

public class BClass {

    private MyPrinter myPrinter;

    public BClass() {
        myPrinter = MyPrinter.getInstance();
    }

    public MyPrinter getMyPrinter() {
        return this.myPrinter;
    }

}
