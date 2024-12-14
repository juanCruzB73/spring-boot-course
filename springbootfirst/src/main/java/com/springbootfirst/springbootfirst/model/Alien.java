package com.springbootfirst.springbootfirst.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("21")
    private int age;
    @Autowired
    private Computer computer;

    public void code(){
        computer.coding();
    }

    public int getAge() {
        return age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Autowired
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
