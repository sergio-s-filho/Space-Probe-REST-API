package com.example.sonda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SondaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SondaApplication.class, args);
	}

}
