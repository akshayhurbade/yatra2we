package com.example.YATRA2we;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class hotel{
    @GetMapping("/myhotel")
    public String getData(){
        return "Please book your room";
    }

}