package com.springbootfirst.springbootfirst.repository;

import com.springbootfirst.springbootfirst.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop laptop){
        System.out.println("saved in database");
    }
}
