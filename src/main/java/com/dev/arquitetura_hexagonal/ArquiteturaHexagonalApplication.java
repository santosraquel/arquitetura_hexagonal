package com.dev.arquitetura_hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dev.arquitetura_hexagonal.infraestrutura.adaptadores.repositories.SpringProdutoRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SpringProdutoRepository.class)
public class ArquiteturaHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquiteturaHexagonalApplication.class, args);
	}

}
