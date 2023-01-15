package com.example.YATRA2we;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Yatra2weApplication {

	public static void main(String[] args) {
		SpringApplication.run(Yatra2weApplication.class, args);
	}

	public static class bus {
		@GetMapping("/mybus")
		public String getData(){
			return "Please book your ola uber and taxi";
		}
	}
}
