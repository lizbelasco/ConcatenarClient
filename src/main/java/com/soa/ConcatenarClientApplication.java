package com.soa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soa.dto.ConcatenarResponse;
import com.soa.soap.ConcatenarClient;

@SpringBootApplication
public class ConcatenarClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcatenarClientApplication.class, args);
	}

	@Bean
    CommandLineRunner lookup(ConcatenarClient client) {
        return args -> {
            ConcatenarResponse response = client.execute();
            System.err.println(response.getNombreCompleto());
        };
    }

    @Bean
    CommandLineRunner otro() {
        return args -> {
            System.out.println("Soy un objeto especial que corre automáticamente");
        };
    }
}
