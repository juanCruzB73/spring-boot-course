package com.springDemo;

public class Alien  {
    private int age;
    private Computer comp;
    public Alien(){
        System.out.println("alien created");
    }
    public Alien(int age,Computer comp){
        System.out.println("PARA CONSTRUCTOR CALLED");
        this.age=age;
        this.comp=comp;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComp() {
        return comp;
    }

    public void setLap(Computer comp) {
        this.comp = comp;
    }

    public void code(){
        System.out.println("coding");
        comp.coding(); 
    }

    
}
