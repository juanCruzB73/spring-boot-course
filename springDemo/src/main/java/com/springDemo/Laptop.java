package com.springDemo;

public class Laptop implements Computer {
    public Laptop(){
        System.out.println("laptop created");
    }
    @Override
    public void coding(){
        System.out.println("coding from laptop");
    }
}
