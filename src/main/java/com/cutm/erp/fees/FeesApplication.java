package com.cutm.erp.fees;

import com.cutm.erp.fees.controller.HibernateAwareObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeesApplication.class, args);
	}
	@Bean
	public ObjectMapper objectMapper(){ return (new HibernateAwareObjectMapper()) ; }

}
