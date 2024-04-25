package org.example.springswaggermongodbtodoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/")
    String helloWorld(){
        return "Hello world!";
    }
}
