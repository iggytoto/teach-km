package com.iggytoto.mvcspringthymeleafexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MvcSpringThymeleafExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcSpringThymeleafExampleApplication.class, args);
	}

}
