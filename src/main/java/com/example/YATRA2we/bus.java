package com.example.YATRA2we;

import org.springframework.web.bind.annotation.GetMapping;

public class bus {
    @GetMapping("/mybus")
    public String getData(){
        return "Please book your ola uber and taxi";
    }
}
