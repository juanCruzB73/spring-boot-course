package com.dataRestDemo.dataRestDemo.app;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    //return type,class name, method name, args
    @Before("execution(* com.dataRestDemo.dataRestDemo.model.JobPost.*(..))")
    public void logMethodCall(){
        LOGGER.info("METHOD CALLED");
    }
}
