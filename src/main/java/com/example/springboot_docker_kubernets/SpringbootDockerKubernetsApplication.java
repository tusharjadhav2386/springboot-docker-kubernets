package com.example.springboot_docker_kubernets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class SpringbootDockerKubernetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerKubernetsApplication.class, args);
	}

}
