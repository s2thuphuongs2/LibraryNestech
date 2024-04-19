package com.example.librarynestech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.example.librarynestech", "com.cloudinary"})

public class LibraryNestechApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryNestechApplication.class, args);
	}

}
