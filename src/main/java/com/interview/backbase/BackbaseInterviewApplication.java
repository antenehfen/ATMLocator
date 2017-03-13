package com.interview.backbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.interview.backbase.controllers","com.interview.backbase.model"
	,"com.interview.backbase.repositories","com.interview.backbase.services",
	"com.interview.backbase.configurations"})
public class BackbaseInterviewApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackbaseInterviewApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BackbaseInterviewApplication.class);
	}
}

