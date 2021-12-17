package com.example.demo.controller;

import com.example.demo.AutowireLogger;
import com.example.demo.InjectDemo;
import com.example.demo.ServiceDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestControllerDemo {

    @AutowireLogger
    private InjectDemo injectDemo;

    @GetMapping("/gege")
    public ServiceDemo hello() {
        injectDemo.hello();
        return null;
    }
}
