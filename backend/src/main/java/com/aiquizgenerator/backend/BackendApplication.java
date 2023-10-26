package com.aiquizgenerator.backend;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class BackendApplication {

	enum DotEnv {
		PORT,
		DATABASE_URL,
		DATABASE_PASSWORD,
		DATABASE_USERNAME
	}


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


}