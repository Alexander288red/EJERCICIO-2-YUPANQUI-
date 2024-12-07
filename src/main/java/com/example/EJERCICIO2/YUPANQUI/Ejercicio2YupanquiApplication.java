package com.example.EJERCICIO2.YUPANQUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.EJERCICIO2.YUPANQUI")

public class Ejercicio2YupanquiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2YupanquiApplication.class, args);
	}

}
