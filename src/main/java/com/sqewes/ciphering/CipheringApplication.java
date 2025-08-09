package com.sqewes.ciphering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sqewes.ciphering.repositories")
@EntityScan(basePackages = "com.sqewes.ciphering.entities")
public class CipheringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CipheringApplication.class, args);
	}

}
