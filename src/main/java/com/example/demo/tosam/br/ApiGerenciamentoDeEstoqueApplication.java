package com.example.demo.tosam.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"controller", "config" , "service" ,"serviceImpl" , "data" ,  "dataImpl" , "domain" , "security" , "util" }) // Ajuste aqui com os pacotes corretos para suas classes de configuração e controladores
@EntityScan(basePackages = "domain") // Ajuste o pacote para onde suas entidades realmente estão
@EnableJpaRepositories(basePackages = {"data" , "config" , "dataImpl"})
public class ApiGerenciamentoDeEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGerenciamentoDeEstoqueApplication.class, args);
	}

}
