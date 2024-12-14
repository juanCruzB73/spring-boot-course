package com.springbootfirst.springbootfirst.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    private String os;

    public Laptop(){}
    public Laptop(String os){
        this.os=os;
    }

    @Override
    public void coding() {
        System.out.println(this.os+" laptop is coding");
    }
    @Override
    public void compile(){
        System.out.println(this.os+" laptop is compileing");
    }

}
