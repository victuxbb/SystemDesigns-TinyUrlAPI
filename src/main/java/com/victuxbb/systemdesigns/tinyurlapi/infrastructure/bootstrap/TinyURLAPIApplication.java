package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.victuxbb.systemdesigns.tinyurlapi.infrastructure"
})
public class TinyURLAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyURLAPIApplication.class, args);
	}

}

