package com.rmnlcn.Hibernate_JPA_CRUD_student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaCrudStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudStudentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}
}
