package com.example.YATRA2we;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class visa{
    @GetMapping("/myvisa")
    public String getData(){
        return "Please book your visa";
    }

}
