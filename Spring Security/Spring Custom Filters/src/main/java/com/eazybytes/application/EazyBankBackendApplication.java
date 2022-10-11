package com.eazybytes.application;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScans({ @ComponentScan("com.eazybytes.controller"), @ComponentScan("com.eazybytes.config")})
@EnableJpaRepositories("com.eazybytes.repository")
@EntityScan("com.eazybytes.model")
@EnableWebSecurity(debug = true)
public class EazyBankBackendApplication {

//	@Autowired
//	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Customer u1 = new Customer();
//		u1.setId(1);
//		u1.setPwd("1234");
//		u1.setEmail("john@gmail.com");
//		u1.setRole("NORMAL");
//		this.customerRepository.save(u1);
//	}
}
