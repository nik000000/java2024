package com.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public String com.aop.controller.HomeController.getData())")
    public void beforeMethod(){
        System.out.println("Before Method");
    }
}
