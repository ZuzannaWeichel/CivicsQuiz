package com.pillar.civicsquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // explore later
public class CivicsQuizApplication {

	public static void main(String[] args) {

		SpringApplication.run(CivicsQuizApplication.class, args);
	}

}
