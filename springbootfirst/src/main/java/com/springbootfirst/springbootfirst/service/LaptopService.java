package com.springbootfirst.springbootfirst.service;

import com.springbootfirst.springbootfirst.model.Laptop;
import com.springbootfirst.springbootfirst.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repository;
    public void addLaptop(Laptop laptop){
        repository.save(laptop);
    }
    public boolean isGoodForProgramming(Laptop lap){
        return true;
    }
}
