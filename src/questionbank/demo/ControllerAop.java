package com.example.demo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAop {

    @Pointcut("execution(public com.example.demo.ServiceDemo *(..))")
    public void pointcut() {
    }

    @AfterReturning(pointcut = "pointcut()")
    public void onReturn() {
        System.out.println("hello");
    }
}
