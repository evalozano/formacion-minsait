package com.paradigma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.paradigma")
public class UnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitApplication.class, args);
	}

}

