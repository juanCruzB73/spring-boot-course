package com.backend.example.BeansIntro;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AplicationConfig {
    @Bean
    @Qualifier("bean1")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("FirstBean");
    }
    @Bean
    @Qualifier("bean2")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("SecondBean");
    }
    @Bean
    @Primary
    public MyFirstClass myThirdBean(){
        return new MyFirstClass("ThirdBean");
    }
}
