package com.mid.example.javamidtest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoApplication {
	public static void main(String[] args) {		
;		SpringApplication.run(DemoApplication.class, args);
		log.debug("RHYMOND::Spring boot application started");
	}
 
	@Autowired
	DataSource dataSource;

	@Bean
	public CommandLineRunner run(CustomerService service){
		log.debug("RHYMOND::Running CommandLineRunner-debug");
		log.info("RHYMOND::Running CommandLineRunner-info");
		log.warn("RHYMOND::Running CommandLineRunner-warn");
		log.error("RHYMOND::Running CommandLineRunner-error");
		
		return (String[] args) -> {
			Customer customer = service.getCustomer(1);
			System.out.println(customer);
		};
	}
}
