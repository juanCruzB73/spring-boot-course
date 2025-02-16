package com.backend.example.BeansIntro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
/*@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:custom.properties"),
})*/
public class MyFirstService {

    private final MyFirstClass myFirstClass;
    //@Value("${my.aplication.property}")
    private String prop;
    //@Value("${my.custom.prop}")
    private String customProp;

    /*SETTER INJECTION*/

    /*CONSTRUCTOR DEPENDIENCY*/
    @Autowired
    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass){
        this.myFirstClass=myFirstClass;
    }


    public String tellAStory(){
        return "the Bean is saying : "+myFirstClass.sayHello();
    }

    /*public String getCustomProp() {
        return customProp;
    }

    public String getProp() {
        return prop;
    }*/
}
