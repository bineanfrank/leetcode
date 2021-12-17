package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ServiceDemo {

    @AutowireLogger
    private InjectDemo demo;

    public void service() {
        demo.hello();
    }
}
