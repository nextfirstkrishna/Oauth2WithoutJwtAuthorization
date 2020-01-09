package com.example.client.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.client.model.Permission;
import com.example.client.model.Role;
import com.example.client.model.User;
import com.example.client.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@ComponentScan(basePackages = { "com.example.client.*" })
@EntityScan("com.example.client.*") 
public class SpringMicroServiceOauth2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroServiceOauth2Application.class, args);
	}
}
 