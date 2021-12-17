package com.vespertino.hotelvesp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelvespApplication {


	public static void main(String[] args) {
		System.out.println("DemoApp...");

		SpringApplication.run(HotelvespApplication.class, args);
		System.out.println("DemoApp inicializado");
	}

}
