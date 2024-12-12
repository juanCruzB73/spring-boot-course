package com.springDemo.config;

import com.springDemo.Alien;
import com.springDemo.Computer;
import com.springDemo.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.springDemo")
public class AppConfig {
    @Bean(name = "laptopLinux")
    @Primary
    public Laptop laptop(){
        return new Laptop();
    }
    @Bean(name = "laptopWondows")
    public Laptop laptopW(){
        return new Laptop();
    }

    @Bean(name = "alien")
    public Alien alien(@Qualifier("laptopLinux") Computer comp){
        Alien alien = new Alien();
        //alien.setAge(21);
        alien.setLap(comp);
        return alien;
    }



}
