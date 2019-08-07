package com.zup.testeselecao;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 
 * @author Emerson Oliveira
 * Classe para execução do sistema
 */
@SpringBootApplication
@EnableJpaAuditing
public class EmployeeApplication {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
