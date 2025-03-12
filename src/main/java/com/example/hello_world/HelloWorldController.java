package com.example.hello_world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("home")
    public String greeting(){
        return "Hello to the World! This is my microservice application";
    }
}
